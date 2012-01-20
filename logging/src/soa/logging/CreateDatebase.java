package soa.logging;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: LUDMILA2
 * Date: 18.01.12
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
import java.sql.*;

public class CreateDatebase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "tigger";

    static Connection conn = null;
    static Statement stmt = null;
    static String database_name = null;

    public static void main(String[] args) {
        try{
                Class.forName(JDBC_DRIVER).newInstance();

                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                database_name = "wsLog";
                String sql = "CREATE DATABASE " + database_name;
                stmt.executeUpdate(sql);
                String sq2 = "USE " + database_name;
                stmt.executeUpdate(sq2);
                String sq3 = "CREATE TABLE LOGT (service_name VARCHAR(30), tag VARCHAR(30), severity INT, message VARCHAR(30));";
                stmt.executeUpdate(sq3);

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
    }
    }
}