<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Search Results</title>
</head>
<body>
<h1>Search Results</h1>
<c:if test="${empty productList}">
  <p>No products found.</p>
</c:if>
<c:if test="${not empty productList}">
  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Image</th>
      <th>Price</th>
      <th>Color</th>
      <th>Size</th>
      <th>Category</th>
      <th>Account</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td><img src="${product.image}" alt="${product.name}" width="100"></td>
        <td>${product.price}</td>
        <td>${product.color}</td>
        <td>${product.size}</td>
        <td>${product.category.name}</td>
        <td>${product.account.user}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</c:if>
</body>
</html>