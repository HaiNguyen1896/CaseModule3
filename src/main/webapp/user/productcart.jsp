<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="vi" class="h-100">

<head>
    <!-- Các thẻ meta cần thiết -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Nền tảng - Kiến thức cơ bản về WEB | Bảng tin</title>
    <!-- Các đường dẫn tới file CSS cần thiết -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../vendor/font-awesome/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../assets/css/app.css" type="text/css">
</head>

<body>
<!-- Mã HTML cho phần header -->
<nav class="navbar navbar-expand-md navbar-dark sticky-top bg-dark">
    <!-- Nội dung phần header -->
</nav>

<main role="main">
    <!-- Nội dung chính trang web -->
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
                                <img src="${product.image}" class="hinhdaidien" style="width: 100%; height: 100%;">
                            </td>
                            <td>${product.detailName}</td>
                            <td class="text-right">
                                <input name="quantity" id="quantity_${product.id}" onchange="calculateTotalPrice(${product.id})">
                            </td>
                            <td class="text-right" id="price_${product.id}">${product.price}</td>
                            <td class="text-right" id="totalPrice_${product.id}">0</td>
                            <td>
                                <a id="delete_${product.id}" data-sp-ma="${product.id}" class="btn btn-danger btn-delete-sanpham">
                                    <i class="fa fa-trash" aria-hidden="true"></i> Xóa
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="http://localhost:8080/user?action=home" class="btn btn-warning btn-md"><i class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;Quay về trang chủ</a>
                <a href="checkout.html" class="btn btn-primary btn-md" style="margin-left: 20px"><i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Thanh toán</a>
            </div>
        </div>
    </div>
</main>

<!-- Các đoạn mã script JavaScript cần thiết -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/popperjs/popper.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/app.js"></script>
<script>
    function calculateTotalPrice(productId) {
        let price = parseFloat(document.getElementById("price_" + productId).innerText);
        let quantity = parseInt(document.getElementById("quantity_" + productId).value);
        let totalPrice = price * quantity;
        document.getElementById("totalPrice_" + productId).innerText = totalPrice.toFixed(2); // Làm tròn tới 2 chữ số thập phân nếu cần
    }
</script>

</body>

</html>