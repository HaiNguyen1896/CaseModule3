package service;

import fillter.ConnectToMySQL;
import model.Account;
import model.Category;
import model.Order;
import model.Product;
import service.IService.IOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrder<Order> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(Order order) {
        String sql = "insert into orders (name,userID,id,status) values(?,?,?,?);";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, order.getName());
            preparedStatement.setInt(2, order.getAccount().getuID());
            preparedStatement.setInt(3, order.getId());
            preparedStatement.setInt(4, order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteOrder(int id) {
        boolean rowDeleted;
        String sql = "delete from orders where id = ?;";
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
    public List<Order> findAll() {
        List<Order> Orderlist = new ArrayList<>();
        String sql = "select orders.*, account.* from orders inner join account on orders.userID = account.uID;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int status = rs.getInt("status");
                int userID = rs.getInt("userID");
                Account account = new Account(userID);
                Order order = new Order(id, name, account, status);
                Orderlist.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Orderlist;
    }
}
