<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product Search</title>
</head>
<body>
<h1>Product Search</h1>
<form action="<c:url value="/search"/>" method="get">
  <label for="searchName">Search:</label>
  <input type="text" id="searchName" name="searchName" required>
  <button type="submit"> Search</button>
</form>
</body>
</html>