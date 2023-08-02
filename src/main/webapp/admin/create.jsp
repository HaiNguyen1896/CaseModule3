<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
  <title>My Form</title>
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
  <form action="http://localhost:8080/user?action=create" method="post" class="my-form">
    <div class="form-group">
      <label for="name">Tên sản phẩm</label>
      <input type="text" class="form-control" id="name" name="name" placeholder="Name">
    </div>
    <div class="form-group">
      <label for="detailName">Mô tả</label>
      <input type="text" class="form-control" id="detailName" name="detailName" placeholder="Detail Name">
    </div>
    <div class="form-group">
      <label for="price">Giá</label>
      <input type="number" class="form-control" id="price" name="price" placeholder="Price">
    </div>
    <div class="form-group">
      <label for="image">Ảnh</label>
      <input type="text" class="form-control" id="image" name="image" placeholder="Image">
    </div>
    <div class="form-group">
      <label for="quantity">Số lượng</label>
      <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity">
    </div>
    <button type="submit" class="btn btn-primary">Thêm mới</button>
  </form>

</div>
</body>
</html>