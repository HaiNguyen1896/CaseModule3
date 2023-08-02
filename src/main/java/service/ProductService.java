package service;

import fillter.ConnectToMySQL;
import model.Category;
import model.Product;
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
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select p.*, c.cname as 'ProductCategory' from product p inner join category c on p.cateID=c.cID;";
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String detailName = rs.getString("detailName");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                int size = rs.getInt("size");
                int idCategory = rs.getInt("cateID");
                String nameCategory = rs.getString("ProductCategory");
                int quantity = rs.getInt("quantity");
                Category category = new Category(idCategory, nameCategory);
                products.add(new Product(id, name, detailName, image, price, color, size, quantity, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean edit(int id, Product product) {
        boolean rowUpdate;
        String sql = "update product set name = ?, detailName=?,image=?,price=?,color=?,size=?,cateID=?,quantity=?  where id = ?;";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDetailName());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setInt(6, product.getSize());
            preparedStatement.setInt(7, product.getCategory().getId());
            preparedStatement.setInt(8, product.getQuantity());
            preparedStatement.setInt(9, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }
}
