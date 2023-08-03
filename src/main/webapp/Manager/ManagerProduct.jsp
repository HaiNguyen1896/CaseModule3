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
    <link href="../css/manager.css" rel="stylesheet" type="text/css"/>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/detail.css" rel="stylesheet" type="text/css"/>
    <style>
        .list-group-item:hover {
            background-color: #f1f1f1;
            cursor: pointer;

        }

        .list-group-item a {
            text-decoration: none;
        }

        .list-group-item a:hover {
            background-color: aqua;
            cursor: pointer;
        }

        .card-title a,
        .btn {
            text-decoration: none;
        }

        .card-title a:hover,
        .btn:hover {
            text-decoration: none;
        }

        .list-group-item a {
            font-size: 18px;
        }

        .breadcrumb-item a {
            font-size: 18px;
        }

        .card.bg-light.mb-3 {
            border: 2px solid #ccc;
            padding: 20px;
        }

    </style>
    <style>
        img {
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
                    <h2>Manage <b>Product</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Thêm sản phẩm mới</span></a>
                    <a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i>
                        <span>Xoá</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                </th>
                <th>ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                    </td>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>
                        <img src="${product.image}">
                    </td>
                    <td>${product.price} $</td>
                    <td>
                        <a href="http://localhost:8080/user?action=edit&id=${product.id}" class="edit"
                           data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Sửa">&#xE254;</i></a>
                        <a href="http://localhost:8080/user?action=delete&id=${product.id}" class="delete"
                           data-toggle="modal"><i class="material-icons"
                                                  data-toggle="tooltip"
                                                  title="Xoá">&#xE872;</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <a href="http://localhost:8080/user?action=admin">
            <button type="button" class="btn btn-primary">Quay về</button>
        </a>

    </div>
    <!-- Edit Modal HTML -->
    <div id="addEmployeeModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="http://localhost:8080/user?action=create" method="post">
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
                            <select name="cateID" class="form-select" aria-label="Default select example">
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
</div>


<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>

