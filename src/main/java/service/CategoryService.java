package service;

import fillter.ConnectToMySQL;
import model.Category;
import model.Product;
import service.IService.ICategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory<Category> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cID");
                String name = rs.getString("cname");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public boolean edit(int id, Category category) {
        return false;
    }
    public Category getCategoryById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Category category = null;

        try {
            // Lấy đối tượng Connection đã có từ ConnectToMySQL.getConnection()
            conn = ConnectToMySQL.getConnection();

            // Truy vấn danh mục theo id
            String sql = "SELECT * FROM categories WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Lấy thông tin danh mục từ ResultSet và tạo đối tượng Category
                String name = rs.getString("name");

                // Tạo đối tượng Category
                category = new Category(id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng PreparedStatement và ResultSet (không đóng Connection vì nó đã được lấy từ ConnectToMySQL.getConnection())
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return category;
    }


}
