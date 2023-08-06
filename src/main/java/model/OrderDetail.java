package model;

import java.time.LocalDate;
import java.util.Date;

public class OrderDetail {
    private int id;
    private Order order;
    private Product product;
    private double totalPrice;
    private int quantity;
    private LocalDate date;

    public OrderDetail(int id, Order order, Product product, double totalPrice, int quantity, LocalDate date) {
        this.id = id;
        this.order = order ;
        this.product = product;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.date = date;
    }
    public OrderDetail(Order order, Product product, double totalPrice, int quantity) {
        this.order = order ;
        this.product = product;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
