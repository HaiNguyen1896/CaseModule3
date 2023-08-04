package service;

import fillter.ConnectToMySQL;
import model.Account;
import model.Order;
import model.OrderDetail;
import model.Product;
import service.IService.IOderDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDetailService implements IOderDetail<OrderDetail> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(OrderDetail orderDetail) {
        String sql = "insert into orderdetail (quantity,totalPrice,productID,accoutID) values(?,?,?,?);";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setDouble(2, orderDetail.getTotalPrice());
            preparedStatement.setInt(3, orderDetail.getProduct().getId());
            preparedStatement.setInt(4, orderDetail.getOrder().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteOrderDetail(int id) {
        boolean rowDeleted;
        String sql = "delete from orderdetail where id = ?;";
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
    public List<OrderDetail> findAll() {
        List<OrderDetail> Orderlist = new ArrayList<>();
        String sql = "select orderdetail.*, account.customerName,product.name from product inner join orderdetail on product.id=orderdetail.productID inner join orders on orderdetail.orderID=orders.id inner join account on orders.userID = account.uID;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Date date = rs.getDate("date");
                int quantity = rs.getInt("quantity");
                double totalPrice = rs.getDouble("totalPrice");
                int orderID = rs.getInt("orderID");
                int customerID = rs.getInt("uID");
                Account account = new Account(customerID);
                Order order = new Order(orderID, account);
                int productID = rs.getInt("productID");
                Product product = new Product(productID);

                OrderDetail orderDetail = new OrderDetail(id, order, product, totalPrice, quantity, date);
                Orderlist.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Orderlist;
    }


    @Override
    public boolean edit(int id, OrderDetail orderDetail) {
        boolean rowUpdate;
        String sql = "update product set id = ?,quantity=?,totalPrice=?,productID=?,orderID=? where id = ?;";
        try (
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,orderDetail.getId());
            preparedStatement.setInt(2, orderDetail.getQuantity());
            preparedStatement.setDouble(3, orderDetail.getTotalPrice());
            preparedStatement.setInt(4, orderDetail.getProduct().getId());
            preparedStatement.setInt(5, orderDetail.getOrder().getId());
            preparedStatement.setInt(6, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }


}
