//package service;
//
//import fillter.ConnectToMySQL;
//import model.Account;
//import model.Order;
//import model.OrderDetail;
//import service.IService.IOderDetail;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderDetailService implements IOderDetail<OrderDetail> {
//    Connection connection = ConnectToMySQL.getConnection();
//
//    @Override
//    public void add(OrderDetail orderDetail) {
//        String sql = "insert into orderdetail (quantity,totalPrice,productID,accoutID) values(?,?,?,?);";
//        try (
//                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setInt(1, orderDetail.getQuantity());
//            preparedStatement.setDouble(2, orderDetail.getTotalPrice());
//            preparedStatement.setInt(3, orderDetail.getProduct().getId());
//            preparedStatement.setInt(4, orderDetail.getOrder().getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean deleteOrderDetail(int id) {
//        boolean rowDeleted;
//        String sql = "delete from orderdetail where id = ?;";
//        try (
//            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setInt(1, id);
//            rowDeleted = preparedStatement.executeUpdate() > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return rowDeleted;
//    }
//
//    @Override
//    public List<OrderDetail> findAll() {
//        List<Order> Orderlist = new ArrayList<>();
//        String sql = "select orderdetail.*, account.name,product.name from product inner join orderdetail on orders.userID = account.uID;";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                int status = rs.getInt("status");
//                int userID = rs.getInt("userID");
//                Account account = new Account(userID);
//                Order order = new Order(id, name, account, status);
//                Orderlist.add(order);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Orderlist;
//    }
//    }
//
//    @Override
//    public boolean edit(int id, OrderDetail orderDetail) {
//        return false;
//    }
//
//
//}
