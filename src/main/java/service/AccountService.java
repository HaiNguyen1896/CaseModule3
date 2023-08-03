package service;

import fillter.ConnectToMySQL;
import model.Account;
import service.IService.IProductService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String query = "insert into account(user, pass, address, tel, role_id) values (?,?,?,?,0);";
        PreparedStatement statement = connection.prepareStatement(query);
        try {
            statement.setString(1, account.getUser());
            statement.setString(2, account.getPass());
            statement.setString(3, account.getAddress());
            statement.setString(4, account.getTel());
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
        String sql = "select  * from account;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String user = resultSet.getString("user");
                String pass = resultSet.getString("pass");
                int role_Id = resultSet.getInt("role_Id");
                String address = resultSet.getString("address");
                int tel = resultSet.getInt("tel");

                Account account = new account(id, user, pass, role_Id, name, age, address, image);
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

}
