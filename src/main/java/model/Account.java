package model;

public class Account {
private int uID;
private String user;
private String pass;
private String customerName;
private String address;
private String tel;
private Role role;

    public Account(int uID, String user, String pass, String customerName, String address, String tel, Role role) {
        this.uID = uID;
        this.user = user;
        this.pass = pass;
        this.customerName= customerName;
        this.address = address;
        this.tel = tel;
        this.role = role;
    }
    public Account( String user, String pass, String customerName, String address, String tel, Role role) {
        this.user = user;
        this.pass = pass;
        this.customerName= customerName;
        this.address = address;
        this.tel = tel;
        this.role = role;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
