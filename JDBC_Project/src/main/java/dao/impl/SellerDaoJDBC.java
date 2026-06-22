package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SellerDao;
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
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                    "SELECT seller.*, department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = Department.Id "
                            + "WHERE seller.Id = ? ");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Departament dep = instantiateDepartament(rs);
                Seller obj = instantiateSeller(rs, dep);
                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    private Seller instantiateSeller(ResultSet rs, Departament dp) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBithDate(rs.getDate("BirthDate"));
        obj.setDepartament(dp);
        return obj;
    }

    private Departament instantiateDepartament(ResultSet rs) throws SQLException {
        Departament dep = new Departament();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setNome(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = Department.Id "
                + "ORDER BY Name "
            );
            
            rs = ps.executeQuery();
            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Departament> map = new HashMap<>();

            while(rs.next()){
                Departament dp = map.get(rs.getInt("DepartmentId"));
                
                if(dp == null){
                    dp = instantiateDepartament(rs);
                    map.put(rs.getInt("DepartmentId"), dp);
                }

                Seller obj = instantiateSeller(rs, dp);
                sellers.add(obj);
            }
            return sellers;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Seller> findByDepartament(Departament dep) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT seller.*, department.Name as DepName "
                + "FROM seller INNER JOIN department "
                + "ON seller.DepartmentId = Department.Id "
                + "WHERE DepartmentId = ? "
                + "ORDER BY Name "
            );

            ps.setInt(1, dep.getId());
            rs = ps.executeQuery();
            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Departament> map = new HashMap<>();

            while(rs.next()){
                Departament dp = map.get(rs.getInt("DepartmentId"));

                if(dp == null){
                    dp = instantiateDepartament(rs);
                    map.put(rs.getInt("DepartmentId"), dp);
                }

                Seller obj = instantiateSeller(rs, dp);
                sellers.add(obj);
            }
            return sellers;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

}
