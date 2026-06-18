package JDBC_Project;
import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import entities.Departament;
import entities.Seller;

public class App {
    public static void main(String[] args) {
        Connection conn = null;
        conn = DB.getConnection();
        DB.closeConnection();
    }
}
