package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String username="root";
    private String password="veysel488";
    private String dbUrl="jdbc:mysql://localhost:3306/world_x";

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(dbUrl,username,password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error CODE: "+exception.getErrorCode());
    }
}
