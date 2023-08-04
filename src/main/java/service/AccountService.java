package service;

import fillter.ConnectToMySQL;
import model.Account;
import model.Role;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    List<Account> accounts = new ArrayList<>();
    Connection connection = ConnectToMySQL.getConnection();

    public void add(Account account) throws SQLException {
        String query = "insert into account(user, pass,customerName ,address, tel, role_id) values (?,?,?,?,?,0);";
        PreparedStatement statement = connection.prepareStatement(query);
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            statement.setString(1, account.getUser());
            statement.setString(2, account.getPass());
            statement.setString(3, account.getCustomerName());
            statement.setString(4, account.getAddress());
            statement.setString(5, account.getTel());
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }


    public void delete(int id) throws SQLException {
        String query = "delete from shpg3.account where id = ?;";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        List<Account> userList = new ArrayList<>();
        String sql = "select  * from account join role on account.role_id = role.id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("user");
                String pass = resultSet.getString("pass");
                String customerName = resultSet.getString("customerName");
                String roleName = resultSet.getString("name");
                String address = resultSet.getString("address");
                String tell = resultSet.getString("tel");
                Role role = new Role(roleName);
                Account account = new Account(id, userName, pass, customerName, address, tell, role);
                userList.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

        public Account findById(int uID) {
            Account account = null;
            String query = "SELECT * FROM user WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, uID);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String customerName = resultSet.getString("customerName");
                    String address = resultSet.getString("address");
                    String tel = resultSet.getString("tel");


                    accounts = (List<Account>) new Account(uID, username, password, customerName, address, tel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return account;
        }
    public void updateInfo(Account account) {
        String query = "UPDATE account SET user = ?, customerName = ?, address = ?, tel = ?, role_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, account.getUser());
            preparedStatement.setString(2, account.getCustomerName());
            preparedStatement.setString(3, account.getAddress());
            preparedStatement.setString(4, account.getTel());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}