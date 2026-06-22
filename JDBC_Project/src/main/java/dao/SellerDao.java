package dao;

import java.util.List;

import entities.Departament;
import entities.Seller;

public interface SellerDao {

    void insert(Seller obj);
    void update(Seller obj);
    void deleteById(Seller obj);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartament(Departament dep);

}