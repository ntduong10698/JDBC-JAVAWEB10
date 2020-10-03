package dao_impl;

import dao.ProductDao;
import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    public Product getObject(ResultSet resultSet) throws SQLException {
        return null;
    }

    public List<Product> getList(ResultSet resultSet) throws SQLException {
        return null;
    }

    public List<Product> findAll() throws SQLException {
        return null;
    }

    public Product findById(int id) throws SQLException {
        return null;
    }

    public Product insert(Product product) throws SQLException {
        return null;
    }

    public boolean update(Product product) throws SQLException {
        return false;
    }

    public boolean delete(int id) throws SQLException {
        return false;
    }
}
