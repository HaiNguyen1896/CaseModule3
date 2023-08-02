<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="css/manager.css" rel="stylesheet" type="text/css"/>
  <style>
    img{
      width: 200px;
      height: 120px;
    }
  </style>
<body>
<div class="container">
  <div class="table-wrapper">
    <div class="table-title">
      <div class="row">
        <div class="col-sm-6">
          <h2>Edit <b>Product</b></h2>
        </div>
        <div class="col-sm-6">
        </div>
      </div>
    </div>
  </div>
  <div id="editEmployeeModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <form action="add" method="post">
          <div class="modal-header">
            <h4 class="modal-title">Thêm sản phẩm mới</h4>
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          </div>
          <div class="modal-body">
            <div class="form-group">
              <label>Tên sản phẩm</label>
              <input name="name" type="text" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Ảnh sản phẩm</label>
              <input name="image" type="text" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Mô tả sản phẩm</label>
              <input name="detailName" type="text" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Giá sản phẩm</label>
              <input name="price" type="number" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Size</label>
              <input name="size" type="text" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Màu sản phẩm</label>
              <input name="color" type="text" class="form-control" required>
            </div>
            <div class="form-group">
              <label>Số lượng sản phẩm</label>
              <input name="quantity" type="number" class="form-control" required>
            </div>

            <div class="form-group">
              <label>Loại sản phẩm</label>
              <select name="category" class="form-select" aria-label="Default select example">
                <c:forEach items="${Category}" var="categories">
                  <option value="${categories.id}">"${categories.name}"</option>
                </c:forEach>
              </select>
            </div>

          </div>
          <div class="modal-footer">
            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
            <input type="submit" class="btn btn-success" value="Add">
          </div>
        </form>
      </div>
    </div>

</div>


<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>
