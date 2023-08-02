    package controller;

    import java.io.IOException;
    import java.util.List;

    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;

    import model.Product;
    import service.ProductService;

    @WebServlet(name= "SearchProduct", value= "/search")
    public class ProductSearch extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String searchName = request.getParameter("searchName");
            ProductService productService = new ProductService();
            List<Product> productList = productService.findProduct(searchName);
            request.setAttribute("productList", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user/search-result.jsp");
            dispatcher.forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doGet(request, response);
        }
    }