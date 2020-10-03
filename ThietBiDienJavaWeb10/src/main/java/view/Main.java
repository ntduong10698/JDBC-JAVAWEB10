package view;

import model.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        MyConnection myConnection = new MyConnection();
        try {
            myConnection.connectDB();

            //demo câu lệnh lấy ra tát cả các bản ghi ở trong bảng category (sử dụng hàm prepare
            // vì đây là câu lệnh tìm kiếm)
            PreparedStatement preare= myConnection.prepare("select * from category");
            //sau khi lấy được đối tượng PreparedStatement thì sẽ sử dụng hàm executeQuery
            // để thực hiện câu lệnh sql và trả một đối tượng ResultSet;
            ResultSet resultSet = preare.executeQuery();
            //để đọc hết tất cả các bản ghi thì phải cho con trỏ resulteSet chạy từ bản ghi đầu đến bản ghi cuối
            //và để làm được điều này thì sẽ sử dụng hàm .next() hàm này trả về
            // giá trị boolean (nếu còn bản ghi sẽ trả về true, còn không có sẽ là false)
            while(resultSet.next()) {
                //resultSet sẽ là một bản ghi
                //dể lấy ra được 1 thuộc tính thì sẽ phải sử dụng hàm get kiểu dữ liệu tương ứng của
                //thuộc tính đó và truyền tên cột của thuộc tính
                System.out.println(resultSet.getString("name"));

                //in ra đầy đủ thuộc tính của 1 bản ghi category vd: 1 Bút điện false;
            }

            //thêm một bản ghi category sử dụng câu lệnh insert => sử dụng hàm prepareUpdate
            PreparedStatement prepareUpdate = myConnection.prepareUpdate("insert into category (name, deleted) values (?,?)");
            //sử dụng các hàm set theo đúng kiểu dữ liệu của các ô muốn truyền thuộc tính vào
            //đầu vào của hàm set sẽ là thứ tự của thuộc tính và giá trị của thuộc tính đấy
            prepareUpdate.setString(1, "Ổ cắm");
            prepareUpdate.setBoolean(2, false);
            int rs = prepareUpdate.executeUpdate(); //đang thực hiện một câu lệnh thay đổi dữ liệu
            if(rs > 0) {
                System.out.println("insert successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
