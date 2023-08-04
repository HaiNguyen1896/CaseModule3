package controller;

import model.Product;
import service.Cart;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String detailName = request.getParameter("detailName");
        String image = request.getParameter("image");
        double productPrice = Double.parseDouble(request.getParameter("productPrice"));
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product(productId, productName, detailName, image, productPrice, color, size, quantity);

        Cart cart = (Cart) request.getSession().getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        cart.addToCart(product);

        response.sendRedirect(request.getContextPath() + "/cart");
    }
}