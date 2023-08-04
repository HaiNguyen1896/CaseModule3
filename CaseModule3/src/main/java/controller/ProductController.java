package controller;

import fillter.SessionAdmin;
import fillter.SessionUser;
import model.Category;
import model.Product;
import service.AccountService;
import service.CategoryService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductController", value = "/user")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    AccountService accountService = new AccountService();


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

        }
        if (check2) {
            switch (action) {
                case "addToCart":
                    addCart(request, response);
                    return;
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

    private void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> productList = productService.findProduct(keyword);
        request.setAttribute("productList", productList);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProduct(id);
        request.setAttribute("productDetail", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/admin.jsp");
        requestDispatcher.forward(request, response);
    }

    private void sortDecrs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.SortByDecreasePrice();
        request.setAttribute("productList", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void sortIncrs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.SortByIncreasePrice();
        request.setAttribute("productList", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request, response);
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProduct(id);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/productcart.jsp");
        requestDispatcher.forward(request, response);
    }

    private void findAllByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> product = productService.findAllByCategory(id);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(request, response);

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
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
        requestDispatcher.forward(request, response);
    }
    private void showHomeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("Category", categories);
        request.setAttribute("productList", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/homeUser.jsp");
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
        }
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