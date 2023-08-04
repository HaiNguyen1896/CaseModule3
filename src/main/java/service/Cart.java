package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addToCart(Product product) {
        items.add(product);
    }

    public void removeFromCart(int productId) {
        items.removeIf(item -> item.getId() == productId);
    }

    public List<Product> getItems() {
        return items;
    }
}