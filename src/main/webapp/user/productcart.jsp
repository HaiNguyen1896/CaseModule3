<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Image</th>
        <th>Name</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total Price</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="cartItem" items="${cartList}">
        <tr>
            <td>${cartItem.id}</td>
            <td>
                <img src="${cartItem.image}" class="hinhdaidien" style="width: 100%; height: 100%;">
            </td>
            <td>${cartItem.detailName}</td>
            <td>${cartItem.categoryName}</td>
            <td class="text-right">
                <input name="quantity" id="quantity_${cartItem.id}" value="${cartItem.quantity}">
            </td>
            <td class="text-right" id="price_${cartItem.id}">${cartItem.price}</td>
            <td class="text-right" id="totalPrice_${cartItem.id}">${cartItem.price * cartItem.quantity}</td>
            <td>
                <a id="delete_${cartItem.id}" data-sp-ma="${cartItem.id}" class="btn btn-danger btn-delete-sanpham">
                    <i class="fa fa-trash" aria-hidden="true"></i> Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>