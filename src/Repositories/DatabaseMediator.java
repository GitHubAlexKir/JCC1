package Repositories;

import Domains.*;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseMediator implements SerializationMediator {
    private Connection con;
    private static final String WRITE_OBJECT_SQL = "INSERT INTO Drawing(drawingname,name, object_value) VALUES (?, ?, ?)";
    static final String READ_OBJECT_SQL = "SELECT object_value FROM drawing WHERE drawingname = ?";

    public DatabaseMediator() throws Exception {
        this.con = getConnection();
    }
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("src\\repositories\\db.properties");
        props.load(in);
        in.close();
        String driver = props.getProperty("jdbc.driver");
        if (driver != null) {
            Class.forName(driver) ;
        }
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        con = DriverManager.getConnection(url, username, password);
        return con;
    }

    @Override
    public Drawing load(String nameDrawing) throws Exception {
        PreparedStatement pstmt = con.prepareStatement(READ_OBJECT_SQL);
        pstmt.setString(1, nameDrawing);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        byte[] buf = rs.getBytes(1);
        ObjectInputStream objectIn = null;
        if (buf != null) {
            objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
        }
        Object deSerializedObject = objectIn.readObject();
        rs.close();
        pstmt.close();
        return (Drawing) deSerializedObject;
    }

    public boolean save(Drawing drawing) throws Exception {
        String className = drawing.getClass().getName();
        PreparedStatement pstmt = con.prepareStatement(WRITE_OBJECT_SQL);
        pstmt.setString(1, drawing.getName());
        pstmt.setString(2, className);
        pstmt.setObject(3, drawing);
        pstmt.executeUpdate();
        pstmt.close();
        return true;
    }
    public boolean init(Properties props) {
        return false;
    }

}
