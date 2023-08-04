package model;

public class Product {
    private int id;
    private String name;
    private String detailName;
    private String image;
    private double price;
    private String color;
    private String size;
    private int quantity;
    private Category category;
    public Product(int id, String name, String detailName, String image, double price, String color, String size, int quantity) {
        this.id = id;
        this.name = name;
        this.detailName = detailName;
        this.image = image;
        this.price = price;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }
    public Product(int id, String name, String detailName, String image, double price, String color, String size, int quantity, Category category) {
        this.id = id;
        this.name = name;
        this.detailName = detailName;
        this.image = image;
        this.price = price;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.category = category;
    }
    public Product(String name, String detailName, String image, double price, String color, String size, int quantity, Category category) {
        this.name = name;
        this.detailName = detailName;
        this.image = image;
        this.price = price;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.category = category;
    }

    public String getCategoryName() {
        return category != null ? category.getName() : "";
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

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
