package soa.logging.ws;

/**
 * Created by IntelliJ IDEA.
 * User: LUDMILA2
 * Date: 06.01.12
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.sql.*;
import java.util.ArrayList;

//Service Implementation
@WebService(endpointInterface = "soa.logging.ws.Logging")
public class LoggingImpl implements Logging{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "tigger";

    Connection conn = null;
    Statement stmt = null;
    String database_name = "wsLog";

    /*
        Severity is an integer specifying message level.
        0 => DEBUG
        1 => INFO
        2 => WARNING
        3 => ERROR
        4 => CRITICAL
        ServiceName is the name of the service (i.e., "WebShop@10.11.12.13")
        Tag is the name of the tag (i.e., "DBManager", "PageGenerator") etc
    */

    @Override
    public void Log(String ServiceName, String Tag, int Severity, String Message)
    {
        try{
            Class.forName(JDBC_DRIVER).newInstance();

            /*if(database_name == null)
            {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                database_name = "LOGGIN2";
                String sql = "CREATE DATABASE " + database_name;
                stmt.executeUpdate(sql);
                String sq2 = "USE " + database_name;
                stmt.executeUpdate(sq2);
                String sq3 = "CREATE TABLE LOGT (service_name VARCHAR(30), tag VARCHAR(30), severity INT, message VARCHAR(30));";
                stmt.executeUpdate(sq3);
            }*/

            conn = DriverManager.getConnection(DB_URL + database_name, USER, PASS);
            stmt = conn.createStatement();
            String sq2 = "USE " + database_name;
            stmt.executeUpdate(sq2);

            PreparedStatement pst = conn.prepareStatement("INSERT INTO LOGT VALUES (?,?,?,?)");
            pst.setString(1, ServiceName);
            pst.setString(2, Tag);
            pst.setInt(3, Severity);
            pst.setString(4, Message);
            pst.execute();
            pst.close();

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

    @Override
    public String[] getMessagesSN(String ServiceName, int minSeverity, int maxSeverity)
    {
        String[] result = null;
        if(database_name != null)
        {
            try
            {
                Class.forName(JDBC_DRIVER).newInstance();
                conn = DriverManager.getConnection(DB_URL + database_name, USER, PASS);

                String sq = "SELECT MESSAGE " +
                            "FROM LOGT " +
                            "WHERE (service_name = ?) & (severity >= ?) & (severity <= ?);";
                PreparedStatement prepStmt = conn.prepareStatement(sq);
                prepStmt.setString(1, ServiceName);
                prepStmt.setInt(2, minSeverity);
                prepStmt.setInt(3, maxSeverity);
                ResultSet rs = prepStmt.executeQuery();

                ArrayList<String> array = new ArrayList<String>();
                while (rs.next()) {
                    array.add(rs.getString("message"));
                }

                result = array.toArray(new String[array.size()]);

                prepStmt.close();
                rs.close();
                conn.close();
            }
            catch (Exception ex) {ex.printStackTrace();}
        }
        return result;
    }

    @Override
    public String[] getMessagesSNT(String ServiceName, String Tag, int minSeverity, int maxSeverity)
    {
        String[] result = null;
        if(database_name != null)
        {
            try
            {
                Class.forName(JDBC_DRIVER).newInstance();
                conn = DriverManager.getConnection(DB_URL + database_name, USER, PASS);

                String sq = "SELECT Message " +
                            "FROM LOGT " +
                            "WHERE (service_name = ?) & (tag = ?) & (severity >= ?) & (severity <= ?);";
                PreparedStatement prepStmt = conn.prepareStatement(sq);
                prepStmt.setString(1, ServiceName);
                prepStmt.setString(2, Tag);
                prepStmt.setInt(3, minSeverity);
                prepStmt.setInt(4, maxSeverity);
                ResultSet rs = prepStmt.executeQuery();

                ArrayList<String> array = new ArrayList<String>();
                while (rs.next()) {
                    array.add(rs.getString("message"));
                }
                result = array.toArray(new String[array.size()]);
                prepStmt.close();
                rs.close();
                conn.close();
            }
            catch (Exception ex) {ex.printStackTrace();}
        }
        return result;
    }
}
