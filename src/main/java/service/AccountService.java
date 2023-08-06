package service;

import fillter.ConnectToMySQL;
import model.Account;
import model.Product;
import model.Role;
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
        try {
            statement.setString(1, account.getUser());
            statement.setString(2, account.getPass());
            statement.setString(3, account.getCustomerName());
            statement.setString(4, account.getAddress());
            statement.setString(5, account.getTel());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
                int id = resultSet.getInt("uID");
                String userName = resultSet.getString("user");
                String pass = resultSet.getString("pass");
                String customerName= resultSet.getString("customerName");
                String roleName = resultSet.getString("name");
                String address = resultSet.getString("address");
                String tell = resultSet.getString("tel");
                Role role=new Role(roleName);
                Account account = new Account(id, userName, pass,customerName ,address, tell, role);
                userList.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public boolean checkUser(String userName, String password) {
        accounts = findAll();
        for (int i = 0; i < accounts.size(); i++) {
            if (userName.equals(accounts.get(i).getUser()) && password.equals(accounts.get(i).getPass())) {
                return true;
            }
        }
        return false;
    }
    public int getIdUser(String username , String password){
        accounts = findAll();
        for (Account account: accounts) {
            if(username.equals(account.getUser()) && password.equals(account.getPass())) {
                return account.getuID();
            }
        }
        return -1;
    }
    public String getRole(String userName, String password) {
        String role = null;
        for (Account account : accounts) {
            if (userName.equals(account.getUser()) && password.equals(account.getPass())) {
                role = account.getRole().getName();
                return role;
            }
        }
        return null;
    }
    public Account findUserById(int id){
        accounts = findAll();
        for (Account account: accounts ) {
            if (account.getuID() == id){
                return account;
            }
        }
        return null;
    }
    public boolean edit(int id, Account account) {
        boolean rowUpdate;
        String sql = "update account set customerName = ?, address=?,tel=? where uID = ?;";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, account.getCustomerName());
            preparedStatement.setString(2, account.getAddress());
            preparedStatement.setString(3, account.getTel());
            preparedStatement.setInt(4, id);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }
}