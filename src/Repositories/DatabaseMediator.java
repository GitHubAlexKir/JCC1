package Repositories;

import Domains.Drawing;

import java.sql.*;
import java.util.Properties;

public class DatabaseMediator implements SerializationMediator {
    private Properties props;
    private Connection con;
    @Override
    public Drawing load(String nameDrawing) {
        try {
           con = DriverManager.getConnection("jdbc:mysql://studmysql01.fhict.local/dbi361412", "dbi361412", "Wachtwoord2");;
            System.out.println("Succsess");
            Statement myStmt = con.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from drawing");
            while (myRs.next()){
                System.out.println(myRs.getString("ID") + ", " + myRs.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println("kut");
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public boolean save(Drawing drawing) {
        return false;
    }

    @Override
    public boolean init(Properties props) {
        return false;
    }
}
