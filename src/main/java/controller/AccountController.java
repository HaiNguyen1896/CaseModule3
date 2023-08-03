package controller;


import fillter.SessionAdmin;
import fillter.SessionURL;
import fillter.SessionUser;
import model.Account;
import model.Role;
import service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AccountController", value = "/Users")
public class AccountController extends HttpServlet {
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.findAll();
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                showFormLogin(request, response);
                break;
            case "register":
                showRegisterForm(request, response);
            case "information":
                showInformation(request, response);
                break;
            case "editCustomer":
                showFormEdit(request, response);
                break;

        }

    }


    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        Account account = accountService.findUserById(id);
        request.setAttribute("user", account);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showInformation(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        Account account = accountService.findUserById(id);
        request.setAttribute("user", account);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/Login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                checkLogin(request, response);
                break;
            case "register":
                try {
                    addRegister(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

    }

    private void addRegister(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        String tel = request.getParameter("tell");
        int role_Id = Integer.parseInt(request.getParameter("role_Id"));
        Role role = new Role(0, "user");
        Account account = new Account(user, pass, customerName, address, tel, role);
        accountService.add(account);
        response.sendRedirect("/Users?action=login");

    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        int id = accountService.getIdUser(userName, password);

        if (accountService.checkUser(userName, password)) {
            String role = accountService.getRole(userName, password);
            HttpSession session = request.getSession();
            session.setAttribute("role", role);
            session.setAttribute("id", id);
            boolean checkAdmin = SessionAdmin.checkUser(request);
            boolean checkMember = SessionUser.checkUser(request);
            if (checkAdmin) {
                try {
                    response.sendRedirect("/user?action=admin");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (checkMember) {
                try {
                    response.sendRedirect("/user?action=home");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            try {
                response.sendRedirect("/Users?action=login");
                accountService.findAll();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}