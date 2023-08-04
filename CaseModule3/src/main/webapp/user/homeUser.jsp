<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Lover web</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark sticky-top bg-dark">
    <div class="container">
        <a class="navbar-brand" href="http://localhost:8080/user?action=home">G3Shop</a>
        <div class="navbar-collapse collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/user?action=home">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.html">Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.html">Liên hệ</a>
                </li>
            </ul>

            <div class="d-flex align-items-center" style="margin-left: 20px;">
                <form class="form-inline mt-2 mt-md-0" method="get" action="search.html">
                    <div class="input-group">
                        <input class="form-control" type="text" placeholder="Tìm kiếm" aria-label="Search" name="keyword_tensanpham">
                        <div class="input-group-append" style="margin-left: 10px">
                            <button class="btn btn-outline-success" type="submit">Tìm kiếm</button>
                        </div>
                    </div>
                </form>
            </div>

        </div>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="cart.html">Giỏ hàng</a>
            </li>
            <li class="nav-item text-nowrap">
                <!-- Nếu chưa đăng nhập thì hiển thị nút Đăng nhập -->
                <a class="nav-link" href="#">Trang cá nhân</a>
            </li>
        </ul>
    </div>
</nav>
<section class="jumbotron text-center" style="background-color: honeydew; padding: 3rem;">
    <div class="container">
        <h1 class="display-4" style="font-weight: bold; color: #333;">Thương hiệu thời trang hàng đầu Việt Nam</h1>
        <p style="font-size: 20px; color: #666;">Chào mừng đến với cửa hàng thời trang. Chúng tôi cam kết mang
            đến cho bạn những sản phẩm thời trang chất lượng nhất và dịch vụ tốt nhất.</p>
        <%--        <a class="btn btn-primary btn-lg" href="#" role="button">Xem sản phẩm</a>--%>
    </div>
</section>

<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Các loại áo
                </div>
                <ul class="list-group category_block">
                    <c:forEach var="categories" items="${Category}">
                        <li class="list-group-item text-white"><a
                                href="http://localhost:8080/user?action=findAllByCategory&id=${categories.id}">${categories.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Sắp xếp theo
                </div>
                <ul class="list-group category_block">
                    <li class="list-group-item text-white"><a href="#">GIÁ TĂNG DẦN</a></li>
                    <li class="list-group-item text-white"><a href="#">GIÁ GIẢM DẦN</a></li>
                </ul>
            </div>


            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Sản phẩm nổi bật</div>
                <div class="card-body">
                    <img class="img-fluid"
                         src="https://oldsailor.com.vn/vnt_upload/product/08_2023/5ad50238abdc788221cd27.jpg"/>
                    <h5 class="card-title">Áo thun</h5>
                    <p class="card-text">Áo thun họa tiết Old Sailor - O.S.L Tennis tee</p>
                    <p class="bloc_left_price">325000 VND</p>
                </div>
            </div>

        </div>

        <div class="col-sm-9">
            <div class="row">
                <c:forEach var="product" items="${productList}">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${product.image}" alt="Card image cap" height="250"
                                 width="250">
                            <div class="card-body">
                                <h4 class="card-title show_txt"><a href="#" title="View Product">${product.name}</a>
                                </h4>
                                <p class="card-text show_txt">${product.detailName}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${product.price} $</p>
                                    </div>
                                    <div class="col">
                                        <a href="http://localhost:8080/user?action=addToCart&id=${product.id}"
                                           class="btn btn-success btn-block" style="margin-left: 30px">Mua ngay</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>

