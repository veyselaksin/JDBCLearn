package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
       selectSQL();
       //insertSQL();
       updateSQL();
       deleteSQL();
    }


    static Connection connection=null;
    static DBHelper dbHelper=new DBHelper();
    static Statement statement=null;
    static PreparedStatement preparedStatement=null;
    static ResultSet resultSet;

    public static void selectSQL() throws SQLException{
        try{
            connection= dbHelper.connection();
            System.out.println("You connected database...");
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM country");
            ArrayList<Country> countries=new ArrayList<>();
            while (resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Capital"),
                        resultSet.getString("Code2")));

                System.out.println("----------  Countries  ----------");
                for (Country country : countries){
                    System.out.println(country.getCode() + "  " +country.getName()+"  "+ country.getCapital()+"  "+country.getCode2());
                }
                System.out.println(countries.size());
            }
        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally {
            connection.close();
        }
    }
    private static void insertSQL() throws SQLException {
        try{
            connection= dbHelper.connection();
            String sql="INSERT INTO country(Code, Name,Capital,Code2) values (?, ?, ?, ?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,"NOX");
            preparedStatement.setString(2,"NOXUS");
            preparedStatement.setInt(3,4000);
            preparedStatement.setString(4,"NX");
            preparedStatement.executeUpdate();
            System.out.println("Data written...");

        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally {
            connection.close();
        }
    }

    private static void updateSQL() throws SQLException {
        try{
            connection= dbHelper.connection();
            String sql="UPDATE country set Capital=3286, Code='ION', Name='IONIA', Code2='IN' where Code=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "ION");
            preparedStatement.executeUpdate();
            System.out.println("Data updated...");

        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally {
            connection.close();
        }
    }
    public static void deleteSQL() throws SQLException{
        try{
            connection= dbHelper.connection();
            String sql="DELETE from country where Code=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, "ION");
            preparedStatement.executeUpdate();
            System.out.println("Data deleted...");

        }catch (SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally {
            connection.close();
        }
    }
}
