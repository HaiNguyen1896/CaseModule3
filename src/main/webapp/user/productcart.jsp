<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="vi" class="h-100">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Nền tảng - Kiến thức cơ bản về WEB | Bảng tin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css">
    <!-- Font awesome -->
    <link rel="stylesheet" href="../vendor/font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Custom css - Các file css do chúng ta tự viết -->
    <link rel="stylesheet" href="../assets/css/app.css" type="text/css">
</head>

<body>
<!-- header -->
<nav class="navbar navbar-expand-md navbar-dark sticky-top bg-dark">
    <div class="container">
        <a class="navbar-brand" href="http://localhost:8080/user?action=home">G3Shop</a>
        <div class="navbar-collapse collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/user?action=home">Trang chủ</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="about.html">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.html">Liên hệ</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0" method="get" action="search.html">
                <input class="form-control mr-sm-2" type="text" placeholder="Tìm kiếm" aria-label="Search"
                       name="keyword_tensanpham">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
            </form>
        </div>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="cart.html">Giỏ hàng</a>
            </li>
            <li class="nav-item text-nowrap">
                <!-- Nếu chưa đăng nhập thì hiển thị nút Đăng nhập -->
                <a class="nav-link" href="login.html">Đăng nhập</a>
            </li>
        </ul>
    </div>
</nav>
<!-- end header -->

<main role="main">
    <!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là `content` -->
    <div class="container mt-4">
        <div id="thongbao" class="alert alert-danger d-none face" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">×</span>
            </button>
        </div>

        <h1 class="text-center">Giỏ hàng</h1>
        <div class="row">
            <div class="col col-md-12">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Ảnh đại diện</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Thành tiền</th>
                        <th>Hành động</th>
                    </tr>

                    </thead>

                    <tbody>
                    <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.id}</td>
                        <td>
                            <img src="${product.image}" class="hinhdaidien" style="width: 100%;height: 100% ">
                        </td>
                        <td>${product.detailName}</td>
                        <td class="text-right"><input name="quantity"></td>
                        <td class="text-right">${product.price}</td>
                        <td class="text-right"><input name="totalPrice"></td>
                        <td>
                            <!-- Nút xóa, bấm vào sẽ xóa thông tin dựa vào khóa chính `sp_ma` -->
                            <a id="delete_1" data-sp-ma="2" class="btn btn-danger btn-delete-sanpham">
                                <i class="fa fa-trash" aria-hidden="true"></i> Xóa
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>


                <a href="http://localhost:8080/user?action=home" class="btn btn-warning btn-md"><i class="fa fa-arrow-left"
                                                                          aria-hidden="true"></i>&nbsp;Quay
                    về trang chủ</a>
                <a href="checkout.html" class="btn btn-primary btn-md" style="margin-left: 20px"><i
                        class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Thanh toán</a>

                </table>
                </div>
        </div>
    </div>
        <!-- End block content -->
</main>

<!-- footer -->
<footer class="footer mt-auto py-3">
    <div class="container">
        <span>Bản quyền © bởi <a href="https://nentang.vn">Nền Tảng</a> - <script>document.write(new Date().getFullYear());</script>.</span>
        <span class="text-muted">Hành trang tới Tương lai</span>

        <p class="float-right">
            <a href="http://localhost:8080/user?action=home">Về đầu trang</a>
        </p>
    </div>
</footer>
<!-- end footer -->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/popperjs/popper.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Custom script - Các file js do mình tự viết -->
<script src="../assets/js/app.js"></script>

</body>

</html>

<script>
    let total = document.getElementById("totalPrice")
    function calculateTotalPrice(productID) {
        let x = document.getElementById("price_${product.id}").value;
        let y = document.getElementById("quantity_${productId}").value;
        let totalPrice=x*y;
        document.getElementById(totalPrice_${productId}).innerText=totalPrice
    }
</script>