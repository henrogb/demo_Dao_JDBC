package dao;

import java.util.List;

import entities.Departament;

public interface DepartmentDao {

    void insert(Departament obj);
    void update(Departament obj);
    void deleteById(Integer obj);
    Departament findById(Integer id);
    List<Departament> findAll();
}
