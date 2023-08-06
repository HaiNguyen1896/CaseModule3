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
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
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
                    <h2><b>Thông tin cá nhân</b></h2>
                </div>
                <div class="col-sm-6">
                </div>
            </div>
        </div>
    </div>
    <div id="editEmployeeModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="http://localhost:8080/user" method="get">
                    <input type="hidden" name="action" value="EditUserInformation">
                    <div class="modal-header">
                        <h4 class="modal-title">Thông tin người dùng</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>ID</label>
                            <input  type="number" class="form-control" value="${accountInfo.uID}" readonly required>
                        </div>
                        <div class="form-group">
                            <label>Họ tên</label>
                            <input  type="text" class="form-control" value="${accountInfo.customerName}" readonly required>
                        </div>

                        <div class="form-group">
                            <label>Địa chỉ</label>
                            <input  type="text" class="form-control"  value="${accountInfo.address}" readonly required>
                        </div>

                        <div class="form-group">
                            <label>Số điện thoại</label>
                            <input  type="number" class="form-control" value="${accountInfo.tel}" readonly required>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <a href="http://localhost:8080/user?action=homeUser" class="btn btn-default" data-dismiss="modal" > Huỷ bỏ</a>
                       <input type="submit" class="btn btn-success" value="Sửa">
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>


<script src="js/manager.js" type="text/javascript"></script>

</body>
</html>
