package JDBC_Project;
import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import entities.Departament;

public class App {
    public static void main(String[] args) {
        Departament d = new Departament(1, "livros");
        System.out.println(d);
    }
}
