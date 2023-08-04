package model;

import java.util.Date;

public class OrderDetail {
    private int id;
    private Order order;
    private Product product;
    private double totalPrice;
    private int quantity;
    private Date date;

    public OrderDetail(int id, Order order, Product product, double totalPrice, int quantity, Date date) {
        this.id = id;
        this.order = order ;
        this.product = product;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
