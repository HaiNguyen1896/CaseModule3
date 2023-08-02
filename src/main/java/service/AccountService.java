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
    List <Account> accounts = new ArrayList<>();
    Connection connection = ConnectToMySQL.getConnection();
    public void add(Account account) throws SQLException {
        String query = "insert into account(user, pass, address, tel, role_id) values (?,?,?,?,0);";
        PreparedStatement statement = connection.prepareStatement(query);
        try{
            statement.setString(1, account.getUser());
            statement.setString(2,account.getPass());
            statement.setString(3,account.getAddress());
            statement.setString(4,account.getTel());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

