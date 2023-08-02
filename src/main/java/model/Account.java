package model;

public class Account {
private int uID;
private String user;
private String pass;
private String address;
private int tel;
private Role role;


    public Account(int uID, String user, String pass, String address, int tel, Role role) {
        this.uID = uID;
        this.user = user;
        this.pass = pass;
        this.address = address;
        this.tel = tel;
        this.role = role;
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
