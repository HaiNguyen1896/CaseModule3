package model;

public class Product {
    private int id;
    private String name;
    private String image;
    private double price;
    private String color;
    private int size;
    private Category category;
    private Account account;

    public Product(int id, String name, String image, double price, String color, int size, Category category, Account account) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.color = color;
        this.size = size;
        this.category = category;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
