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
            case "add":
                showFormAdd(request, response);
                break;
        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

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
            case "add":
                addProduct(request, response);
                break;
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String detailName = request.getParameter("detalName");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        int size = Integer.parseInt(request.getParameter("size"));
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        Category category = new Category(cateID);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(name,detailName,img,price,color,size,quantity,category);

        response.sendRedirect("http://localhost:8080/user?action=home");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String detailName = request.getParameter("detalName");
        String img = request.getParameter("img");
        double price = Double.parseDouble(request.getParameter("price"));
        String color = request.getParameter("color");
        int size = Integer.parseInt(request.getParameter("size"));
        int cateID = Integer.parseInt(request.getParameter("cateID"));
        Category category = new Category(cateID);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(id,name,detailName,img,price,color,size,quantity,category);
        productService.edit(id,product);
        response.sendRedirect("http://localhost:8080/user?action=home");
    }
}