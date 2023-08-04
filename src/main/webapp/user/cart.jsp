<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<h1>Giỏ hàng</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Chi tiết</th>
        <th>Giá</th>
        <th>Màu sắc</th>
        <th>Size</th>
        <th>Số lượng</th>
    </tr>
    <c:forEach var="product" items="${cart.items}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.detailName}</td>
            <td>${product.price}</td>
            <td>${product.color}</td>
            <td>${product.size}</td>
            <td>${product.quantity}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>