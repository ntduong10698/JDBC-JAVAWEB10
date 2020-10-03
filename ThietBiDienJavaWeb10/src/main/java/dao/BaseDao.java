package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * mỗi đối tượng đều có hàm chung cơ bản sau
 * findAll(): lấy tất cả các bản ghi từ một bảng trong database
 * findById(int id) : lấy ra một bản ghi có id tương ứng
 * insert(): thêm một bản ghi
 * update(): thây đổi dữ liệu của 1 bản ghi
 * delete(): xóa một bản ghi
 *
 *
 * getObject, getList chuyển resultset về 1 đối tượng hoặc 1 list đối tượng
 */
public interface BaseDao<T> {

    T getObject(ResultSet resultSet) throws SQLException;

    List<T> getList(ResultSet resultSet) throws SQLException;

    List<T> findAll() throws SQLException;

    T findById(int id) throws SQLException;

    T insert(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(int id) throws SQLException;
}
