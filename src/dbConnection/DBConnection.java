/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.*;

/**
 *
 * @author aniat
 */
public class DBConnection {

    public static Connection connection = null;
    public static String clientId = "";

    public static ResultSet makeQuery(String sqlQuery) throws SQLException{   
        Statement statement = getGlobalConnection().createStatement();
        return statement.executeQuery(sqlQuery);  
    }

    public static Connection getGlobalConnection() {
        return connection;
    }

    public Connection getConnection() {
        connection = null;
        try {

            String url = null;
            String user = null;
            String password = null;
            
//            <============MD. ATIKUR RAHMAN============>
//            password = "123456";
//            user = "Atiqur";
//            url = "jdbc:sqlserver://localhost\\SQLExpress:1433;databaseName=VaccinationCenter";
//            <--------------- Ahmed Saad Tanim ------------->
//            password = "123456";
//            user = "AST";
//            url = "jdbc:sqlserver://AST-PC\\SQLEXPRESS:1433;databaseName=VaccinationCenter";
//            <--------------- Sanjid Islam Chowdhury ----------->
            password = "123456";
            user = "san2";
            url = "jdbc:sqlserver://lassassins-blad\\SQLEXPRESS:1433;databaseName=VaccinationCenter";

            connection = DriverManager.getConnection(url, user, password);
            clientId = connection.toString().substring(35, connection.toString().length());
            System.out.println(clientId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
