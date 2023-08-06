package controller;

import fillter.SessionAdmin;
import fillter.SessionUser;
import model.*;
import service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController", value = "/user")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    AccountService accountService = new AccountService();
    OrderDetailService orderDetailService = new OrderDetailService();
    OrderService orderService = new OrderService();
    List<Product> productCard =new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        accountService.findAll();
        boolean check = SessionAdmin.checkUser(request);
        boolean check2 = SessionUser.checkUser(request);
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHome(request, response);
                return;
            case "findAllByCategory":
                findAllByCategory(request, response);
                return;
            case "sortIncrease":
                sortIncrs(request, response);
                return;
            case "sortDecrease":
                sortDecrs(request, response);
                return;
            case "showDetailProduct":
                showDetailProduct(request, response);
                return;
            case "findProduct":
                findProduct(request, response);
                return;
            case "showUserInfomation":
                showUserInformation(request, response);
                return;
            case "EditUserInformation":
                showEditUserInformation(request,response);
                return;

        }
        if (check2) {
            switch (action) {
                case "addToCart":
                    addCart(request, response);
                    return;
                case "homeUser":
                    showHomeUser(request, response);
                    return;
                case "cart":
                    showCart(request, response);
                    return;
                case "showCart":
                    showMyCart(request,response);
                    return;
                case "deleteCartProduct":
                    deleteCartProduct(request,response);

            }
        } else if (check) {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    return;
                case "create":
                    showFormAdd(request, response);
                    return;
                case "admin":
                    showFormAdmin(request, response);
                    return;
                case "manager":
                    showFormManager(request, response);
                    return;
                case "delete":
                    deleteProduct(request, response);
                    return;
                case "showDetailProduct":
                    showDetailProduct(request, response);
                    return;

            }
        } else {
            response.sendRedirect("http://localhost:8080/User?action=login");

        }
    }

    private void deleteCartProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        for(int i=0 ; i<productCard.size();i++){
            if(productCard.get(i).getId()==id){
                productCard.remove(i);
            }
        }
        request.setAttribute("productList", productCard);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/productcart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showMyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", productCard);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/productcart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditUserInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        Account account = accountService.findUserById(id);
        request.setAttribute("accountInfo", account);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/ShowEditInformation.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showUserInformation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        accountService.findAll();
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        Account account = accountService.findUserById(id);
        request.setAttribute("accountInfo", account);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/showInformation.jsp");
        requestDispatcher.forward(request, response);
    }


    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> productList = productService.findProduct(keyword);
        request.setAttribute("productList", productList);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);

        } else if (role.equals("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProduct(id);
        request.setAttribute("productDetail", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
        requestDispatcher.forward(request, response);
    }

    private void sortDecrs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        List<Product> products = productService.SortByDecreasePrice();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", products);
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);

        } else if (role.equals("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void sortIncrs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        List<Product> products = productService.SortByIncreasePrice();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", products);
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);

        } else if (role.equals("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProduct(id);
//        productList.add(product); đang hoat động
        productCard.add(product);
        HttpSession session = request.getSession();
        int iduser = (int) session.getAttribute("id");
        Account account = accountService.findUserById(iduser);
        Order order = new Order(account);
        orderService.add(order);
        request.setAttribute("productList", productCard);
        OrderDetail orderDetail = new OrderDetail(order,product,0,0);
        orderDetailService.add(orderDetail);
        response.sendRedirect("http://localhost:8080/user?action=homeUser");
    }

    private void findAllByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> product = productService.findAllByCategory(id);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);

        } else if (role.equals("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
            requestDispatcher.forward(request, response);
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("http://localhost:8080/user?action=manager");
    }

    private void showFormManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Manager/ManagerProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        request.setAttribute("productList", product);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProduct(id);
        request.setAttribute("product", product);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Manager/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
            requestDispatcher.forward(request, response);

        } else if (role.equals("admin")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    private void showHomeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/cart.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "edit":
                editProduct(request, response);
                break;
            case "create":
                addProduct(request, response);
                break;
            case "editUserInformation":
                editUserInfor(request,response);
                break;
        }
    }

    private void editUserInfor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
        String user = request.getParameter("fullname");
        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        Account account = new Account(id,user,address,tel);
        accountService.edit(id,account);
        response.sendRedirect("http://localhost:8080/user?action=showUserInfomation");
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String detailName = request.getParameter("detailName");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = new Category(cateID);
        Product product = new Product(name, detailName, image, price, color, size, quantity, category);
        productService.add(product);
        response.sendRedirect("http://localhost:8080/user?action=manager");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String detailName = request.getParameter("detailName");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        int cateID = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = new Category(cateID);
        Product product = new Product(name, detailName, image, price, color, size, quantity, category);
        productService.edit(id, product);
        response.sendRedirect("http://localhost:8080/user?action=manager");
    }
}