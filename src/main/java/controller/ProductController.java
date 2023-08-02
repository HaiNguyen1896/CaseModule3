package controller;

import model.Category;
import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/user")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHome(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "create":
                showFormAdd(request, response);
                break;
            case "admin":
                showFormAdmin(request, response);
                break;

        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/create.jsp");
        dispatcher.forward(request, response);
    }


    private void showFormAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        request.setAttribute("productList", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/admin.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> product = productService.findAll();
        request.setAttribute("productList", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user/home.jsp");
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
        int size = Integer.parseInt(request.getParameter("size"));
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = new Category(cateID);
        Product product = new Product(name,detailName,image,price,color,size,quantity,category);
        productService.add(product);
        response.sendRedirect("http://localhost:8080/user?action=home");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String detailName = request.getParameter("detailName");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        int size = Integer.parseInt(request.getParameter("size"));
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Category category = new Category(cateID);
        Product product = new Product(name,detailName,image,price,color,size,quantity,category);
        productService.edit(id,product);
        response.sendRedirect("http://localhost:8080/user?action=home");
    }
}