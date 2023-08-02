package service;

import fillter.ConnectToMySQL;
import model.Account;
import model.Category;
import model.Product;
import model.Role;
import service.IService.IProductService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService<Product> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findProduct(String search) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = ConnectToMySQL.getConnection();
            if (connection != null) {
                String sql = "SELECT * FROM product WHERE name like concat('%',?,'%')";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, search);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String image = resultSet.getString("image");
                    double price = resultSet.getDouble("price");
                    String color = resultSet.getString("color");
                    int size = resultSet.getInt("size");
                    int categoryId = resultSet.getInt("cateID");
                    int sellId = resultSet.getInt("sell_ID");
                    Category category = getCategoryById(categoryId);
                    Account account = getAccountById(sellId);
                    if (category != null && account != null) {
                        Product product = new Product(id, name, image, price, color, size, category, account);
                        productList.add(product);
                    }
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void edit(int id) {

    }

    private Role getRoleById(int roleId) {
        Role role = null;
        try {
            String sql = "SELECT * FROM role WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roleId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                role = new Role(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    private Category getCategoryById(int categoryId) {
        Category category = null;
        try {
            String sql = "SELECT * FROM category WHERE cID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoryId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int cID = resultSet.getInt("cID");
                String cname = resultSet.getString("cname");
                category = new Category(cID, cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    private Account getAccountById(int accountId) {
        Account account = null;
        try {
            String sql = "SELECT * FROM account WHERE uID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, accountId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int uID = resultSet.getInt("uID");
                String user = resultSet.getString("user");
                String pass = resultSet.getString("pass");
                String address = resultSet.getString("address");
                int tel = resultSet.getInt("tel");
                int roleId = resultSet.getInt("role_id");
                Role role = getRoleById(roleId);
                account = new Account(uID, user, pass, address, tel, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
