<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;"
     id="mySidebar">
    <div class="w3-container">
        <h3 class="w3-padding-64"><b>Home</b></h3>
    </div>
    <div class="w3-bar-block" style="height: 800px">
        <a href="#" class="w3-bar-item w3-button w3-hover-white">Trang chủ</a>
        <a href="#showcase" class="w3-bar-item w3-button w3-hover-white">Tìm Kiếm sản phẩm</a>
        <a href="#services" class="w3-bar-item w3-button w3-hover-white">Lọc sản phẩm</a>
        <a href="#designers" class="w3-bar-item w3-button w3-hover-white">Xem giỏ hàng</a>
    </div>
</nav>

<div class="container mt-5">
    <div class="row">
        <c:forEach var="product" items="${productList}">
            <div class="col-lg-4">
                <div class="card">
                    <img src="${product.image}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
<%--                        <p class="card-text">${product.description}</p>--%>
                        <p class="card-text">${product.price}</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!-- Footer -->
<div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px; position: fixed; width: 100%; bottom: 0px">
    <p class="w3-right"> Web bán hàng uy tín hàng đầu việt nam</p>
</div>
</body>
</html>