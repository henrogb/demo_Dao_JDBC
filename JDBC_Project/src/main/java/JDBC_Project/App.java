package JDBC_Project;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
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
        Departament dp = new Departament(2, null);

        Seller seller = new Seller(10, "Gilso", "henzogilso@gmail.com", new Date(), 7000.00, dp);
        sd.update(seller);  
    }
}
