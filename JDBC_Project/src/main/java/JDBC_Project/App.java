package JDBC_Project;
import java.sql.Connection;
import java.sql.SQLException;

import dao.DaoFactory;
import dao.SellerDao;
import db.DB;
import db.DbException;
import entities.Departament;
import entities.Seller;

public class App {
    public static void main(String[] args) {
       SellerDao sellerDao = DaoFactory.createSellerDao();

       Seller seller = sellerDao.findById(3);

       System.out.println(seller);
    }
}
