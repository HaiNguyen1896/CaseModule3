package controller;

import service.Cart;
import model.Product;
import service.ProductService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý hiển thị giỏ hàng tại đây (nếu cần)
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ProductService productDAO = new ProductService(); // Giả sử có lớp ProductService để lấy thông tin sản phẩm từ cơ sở dữ liệu
        Product product = productDAO.getProductById(productId);

        if (product != null) {
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }

            // Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
            if (cart.containsProduct(product)) {
                // Nếu đã có thì tăng số lượng sản phẩm trong giỏ hàng
                cart.updateQuantity(product, quantity);
            } else {
                // Nếu chưa có thì thêm sản phẩm vào giỏ hàng với số lượng chỉ định
                cart.addProduct(product, quantity);
            }
        }

        response.sendRedirect(request.getContextPath() + "/cart");
    }


}