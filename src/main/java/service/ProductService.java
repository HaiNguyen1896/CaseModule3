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
    List<Product> products = new ArrayList<>();


    @Override
    public void add(Product product) {
        String sql = "insert into product (name, detailName, image, price, color, size, cateID, quantity) values(?,?,?,?,?,?,?,?);";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDetailName());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getSize());
            preparedStatement.setInt(7, product.getCategory().getId());
            preparedStatement.setInt(8, product.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean rowDeleted;
        String sql = "delete from product where id = ?;";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
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
                String size = rs.getString("size");
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
        String sql = "update product set name = ?, detailName=?,image=?,price=?,color=?,size=?,cateID=?,quantity=? where id = ?;";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDetailName());
            preparedStatement.setString(3, product.getImage());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getSize());
            preparedStatement.setInt(7, product.getCategory().getId());
            preparedStatement.setInt(8, product.getQuantity());
            preparedStatement.setInt(9, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }

    public Product selectProduct(int id) {
        Product product = null;
        String sql = "select name,image,detailName,price,size,color,quantity,cateID from product where id=?;";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String img = rs.getString("image");
                String detailName = rs.getString("detailName");
                int price = rs.getInt("price");
                String size = rs.getString("size");
                String color = rs.getString("color");
                int quantity = rs.getInt("quantity");
                int cateID = rs.getInt("cateID");
                Category category = new Category(cateID);
                product = new Product(id, name, detailName, img, price, color, size, quantity, category);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> findAllByCategory(int idCategory) {
        String sql = "select p.*, c.cname as 'ProductCategory' from product p inner join category c on p.cateID=c.cID where p.cateID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCategory);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String detailName = rs.getString("detailName");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                String size = rs.getString("size");
//                int idCategory = rs.getInt("cateID");
                String nameCategory = rs.getString("ProductCategory");
                int quantity = rs.getInt("quantity");
                Category category = new Category(idCategory, nameCategory);
                products.add(new Product(idProduct, name, detailName, image, price, color, size, quantity, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public List<Product> findAllByCateID(int cateID) {
        List<Product> products = new ArrayList<>();
        String sql = "select p.*, c.cname as 'ProductCategory' from product p inner join category c on p.cateID=c.cID where p.cateID=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cateID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String detailName = rs.getString("detailName");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                String size = rs.getString("size");
                String nameCategory = rs.getString("ProductCategory");
                int quantity = rs.getInt("quantity");
                Category category = new Category(cateID, nameCategory);
                products.add(new Product(idProduct, name, detailName, image, price, color, size, quantity, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> SortByIncreasePrice() {
        List<Product> products = new ArrayList<>();
        String sql = "select p.*, c.cname as 'ProductCategory' from product p inner join category c on p.cateID=c.cID order by price;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String detailName = rs.getString("detailName");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                String size = rs.getString("size");
                int idCategory = rs.getInt("cateID");
                String nameCategory = rs.getString("ProductCategory");
                int quantity = rs.getInt("quantity");
                Category category = new Category(idCategory, nameCategory);
                products.add(new Product(idProduct, name, detailName, image, price, color, size, quantity, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> SortByDecreasePrice() {
        List<Product> products = new ArrayList<>();
        String sql = "select p.*, c.cname as 'ProductCategory' from product p inner join category c on p.cateID=c.cID order by price desc ;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String detailName = rs.getString("detailName");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                String size = rs.getString("size");
                int idCategory = rs.getInt("cateID");
                String nameCategory = rs.getString("ProductCategory");
                int quantity = rs.getInt("quantity");
                Category category = new Category(idCategory, nameCategory);
                products.add(new Product(idProduct, name, detailName, image, price, color, size, quantity, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findProduct(String search) {
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product WHERE detailName like concat('%',?,'%');";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, search);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String detailName = rs.getString("detailName");
                String image = rs.getString("image");
                double price = rs.getDouble("price");
                String color = rs.getString("color");
                String size = rs.getString("size");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("cateID");
                Category category = getCategoryById(categoryId);
                if (category != null) {
                    Product product = new Product(id, name, detailName, image, price, color, size, quantity, category);
                    productList.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    private Category getCategoryById(int categoryId) {
        Category category = null;
        try {
            String sql = "SELECT * FROM category WHERE cID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoryId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int cID = rs.getInt("cID");
                String cname = rs.getString("cname");
                category = new Category(cID, cname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}




