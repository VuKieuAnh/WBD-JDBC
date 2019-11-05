import java.sql.*;

public class LecturersManager {
    private static Connection mysqlConnection;

    public static void openConnection() throws SQLException {
        try {
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3308/codegym", "root", "123456");
        } catch (SQLException e) {
            System.out.println("Có lỗi khi kết nối cơ sở dữ liệu");
            System.out.println(e.getMessage());
        }
    }

    public static void closeConnection() throws SQLException {
        if (mysqlConnection != null && !mysqlConnection.isClosed()) {
            mysqlConnection.close();
        }
    }

    public static Statement createStatement() throws SQLException {

        if (mysqlConnection == null) {
            openConnection();
        }

        Statement statement= mysqlConnection.createStatement();
        return statement;
    }

    public static PreparedStatement createPrepareStatement(String sql) throws SQLException {

        if (mysqlConnection == null) {
            openConnection();
        }

        PreparedStatement statement= mysqlConnection.prepareStatement(sql);
        return statement;
    }

    public static void main(String[] args) {
        try {
            openConnection();

            // Đọc dữ liệu
//            Statement statement = createStatement();
////            ResultSet result = statement.executeQuery("SELECT * FROM giangvien");
//            ResultSet result = statement.executeQuery("SELECT * FROM giangvien");
//            while(result.next()){
//                System.out.println(result.getString(1)+"\t"+result.getString(2));
//            }


            // Thêm GV
//            String sql = "INSERT INTO giangvien (id, fullname) VALUES (?, ?)";
//
//            PreparedStatement statement = createPrepareStatement(sql);
//            statement.setInt(1, 10);
//            statement.setString(2, "Nhat");
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Giảng viên mới đã được thêm thành công");
//            }

            // Update
//            String sql = "UPDATE giangvien SET fullname=? WHERE id=?";
//
//            PreparedStatement statement = createPrepareStatement(sql);
//            statement.setString(1, "Gates");
//            statement.setInt(2, 4);
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Cap nhat thanh cong!");
//            }

            // Xóa giảng viên
            String sql = "DELETE FROM giangvien WHERE id=?";

            PreparedStatement statement = createPrepareStatement(sql);
            statement.setInt(1, 4);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Giảng viên mới đã được xóa thành công!");
            }

            closeConnection();
        } catch (SQLException e) {
            System.out.println("Lỗi");
            System.out.println(e.getMessage());
        } finally {
        }
    }
}
