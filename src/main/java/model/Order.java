package model;

public class Order {
    private int id;
    private String name;
    private Account account;
    private int status;
    public Order() {
        this.status = 0;
    }
    public Order(int id, String name, Account account, int status) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.status = status;
    }
    public Order(int id,Account account) {
        this.id = id;
        this.account=account;
    }
    public Order(int id) {
        this.id = id;
    }
    public Order(Account account) {
        this.account = account;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
