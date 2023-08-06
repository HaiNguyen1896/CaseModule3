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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailService implements IOderDetail<OrderDetail> {
    Connection connection = ConnectToMySQL.getConnection();

    @Override
    public void add(OrderDetail orderDetail) {
        String sql = "insert into orderdetail (quantity,totalPrice,productID,orderID) values(?,?,?,?);";
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
        List<OrderDetail> OrderDetaillist = new ArrayList<>();
        String sql = "select od.*,o.userID, a.customerName as 'customername', p.name as 'productname', c.cname as 'category'\n" +
                "from account a\n" +
                "inner join orders o on a.uID = o.userID\n" +
                "inner join orderdetail od on o.id = od.orderID\n" +
                "inner join product p on od.productID = p.id\n" +
                "inner join category c on p.cateID = c.cID;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                LocalDate date  = rs.getDate("date").toLocalDate();
                int quantity = rs.getInt("quantity");
                double totalPrice = rs.getDouble("totalPrice");
                int productID = rs.getInt("productID");
                String productname = rs.getString("productname");
                int orderID = rs.getInt("orderID");
                int uID = rs.getInt("userID");
                Account account = new Account(uID);
                Product product = new Product(productID,productname);
                Order order = new Order(orderID,account);
                OrderDetail orderDetail = new OrderDetail(id, order, product, totalPrice,quantity,date);
                OrderDetaillist.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return OrderDetaillist;
    }
    

    @Override
    public boolean edit(int id, OrderDetail orderDetail) {
        return false;
    }


}
