package dao_impl;

import dao.ProductDao;
import model.MyConnection;
import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private MyConnection myConnection = new MyConnection();

    public Product getObject(ResultSet resultSet) throws SQLException {
        Product product = null;
        product = new Product(resultSet.getInt("id"), resultSet.getString("name"),
                resultSet.getDouble("price"), resultSet.getDate("create_time"),
                resultSet.getBoolean("deleted"), resultSet.getString("image"),
                resultSet.getString("introduction"),
                resultSet.getString("specification"),
                resultSet.getBoolean("sold_out"), resultSet.getInt("guarantee"),
                resultSet.getInt("category_id"), resultSet.getInt("bought"),
                resultSet.getInt("promotion"));
        return product;
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
