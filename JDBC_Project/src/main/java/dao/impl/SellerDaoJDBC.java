package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.SellerDao;
import db.DB;
import db.DbException;
import entities.Departament;
import entities.Seller;

public class SellerDaoJDBC implements SellerDao {
    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Seller obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = Department.Id "
                + "WHERE seller.Id = ? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()){
                Departament dep = new instantiateDepartament();
                Seller obj = new Seller();
                obj.setId(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setBithDate(rs.getDate("BirthDate"));
                obj.setDepartament(dep);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } 

    }

    private Departament instantiateDepartament(ResultSet rs) throws SQLException{
        Departament dep = new Departament();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setNome(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
