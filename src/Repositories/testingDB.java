package Repositories;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testingDB {
    private static final String SQL_SERIALIZE_OBJECT = "INSERT INTO serialized_java_objects(object_name, serialized_object) VALUES (?, ?)";
    private static final String SQL_DESERIALIZE_OBJECT = "SELECT serialized_object FROM serialized_java_objects WHERE serialized_id = ?";

    public long serializeJavaObjectToDB(Connection connection,Object objectToSerialize) throws SQLException {

        PreparedStatement pstmt = connection.prepareStatement(SQL_SERIALIZE_OBJECT);

        // just setting the class name
        pstmt.setString(1, objectToSerialize.getClass().getName());
        pstmt.setObject(2, objectToSerialize);
        pstmt.executeUpdate();
        pstmt.close();
        System.out.println("Java object serialized to database. Object: "
                + objectToSerialize);
        return 1;
    }
    public Object deSerializeJavaObjectFromDB(Connection connection, long serialized_id) throws SQLException, IOException,
            ClassNotFoundException {
        PreparedStatement pstmt = connection.prepareStatement(SQL_DESERIALIZE_OBJECT);
        pstmt.setLong(1, serialized_id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        byte[] buf = rs.getBytes(1);
        ObjectInputStream objectIn = null;
        if (buf != null)
            objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
        Object deSerializedObject = objectIn.readObject();
        rs.close();
        pstmt.close();
        return deSerializedObject;
    }
}
