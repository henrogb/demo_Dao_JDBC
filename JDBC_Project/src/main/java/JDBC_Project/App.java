package JDBC_Project;
import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import entities.Departament;
import entities.Seller;

public class App {
    public static void main(String[] args) {
        Departament d = new Departament(1, "livros");
        Seller s = new Seller();

        System.out.println(s);
    }
}
