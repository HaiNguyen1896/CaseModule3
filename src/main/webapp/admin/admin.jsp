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
  <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">Shoes</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
      <ul class="navbar-nav m-auto">
        <li class="nav-item">
          <a class="nav-link" href="http://localhost:8080/user?action=create">Thêm sản phầm</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"> Sửa sản phẩm</a>
        </li>
      </ul>

      <form action="#" method="post" class="form-inline my-2 my-lg-0">
        <div class="input-group input-group-sm">
          <input name="txt" type="text" class="form-control" aria-label="Small"
                 aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
          <div class="input-group-append">
            <button type="submit" class="btn btn-secondary btn-number">
              <i class="fa fa-search"></i>
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</nav>
<section class="jumbotron text-center">
  <div class="container">
    <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
    <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày nhập từ
      Trung Quốc</p>
  </div>
</section>
<div class="container">
  <div class="row">
    <div class="col">
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="http://localhost:8080/user?action=home">Trang chủ</a></li>
          <li class="breadcrumb-item"><a href="#">Các loại giày</a></li>
        </ol>
      </nav>
    </div>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="col-sm-3">
      <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Các loại giày
        </div>
        <ul class="list-group category_block">
          <c:forEach var="product" items="${productList}">
            <li class="list-group-item text-white"><a href="#">${product.name}</a></li>
          </c:forEach>
        </ul>
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
                    <a href="#" class="btn btn-success btn-block">Xoá sản phẩm</a>
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

