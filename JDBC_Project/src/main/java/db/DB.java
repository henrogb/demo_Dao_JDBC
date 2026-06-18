package db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DB {
    private static Connection conn = null;

    public static Connection getConnection(){
        if (conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
                System.out.println("abrindo conexão...");
                System.out.println(conn.getCatalog());
            } catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }



    public static void closeConnection(){
        if (conn != null){
            try{
                conn.close();
                System.out.println("fechando conexão com o banco...");
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }



    public static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("JDBC_Project\\src\\main\\resources\\db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch(IOException e){
            throw new DbException(e.getMessage());
        }

    }

}
