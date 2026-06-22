package JDBC_Project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.DaoFactory;
import dao.SellerDao;
import db.DB;
import db.DbException;
import entities.Departament;
import entities.Seller;

public class App {
    public static void main(String[] args) {
        SellerDao sd = DaoFactory.createSellerDao();

        List<Seller> sellers = sd.findAll();
        for (Seller seller : sellers){
            System.out.println(seller);
        }
        
    }
}
