package com.example.e_learning;

public class UserHelperClass {
    String name,email,phone,password,joinAs;

    public UserHelperClass() {
    //Empty constructor
    }

    public UserHelperClass(String name, String email, String phone, String password, String joinAs) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.joinAs = joinAs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinAs() {
        return joinAs;
    }

    public void setJoinAs(String joinAs) {
        this.joinAs = joinAs;
    }
}
