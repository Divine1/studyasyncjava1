package com.studyasync.com.oldApproach;

import java.sql.*;

public class MysqlOld {
    public static void run() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(connectionUrl,"root","test");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from Person");

        while(rs.next()){
            String firstname= rs.getString("firstname");
            String lastname= rs.getString("lastname");
            System.out.println("name "+firstname+"-"+lastname);

        }
        rs.close();
        connection.close();

    }
}
