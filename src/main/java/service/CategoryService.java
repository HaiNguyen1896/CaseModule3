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

    public static void main(String[] args) {
        
    }
}
