package org.example.app.entities;

public class Employee {

    int id;
    String first_name;
    String last_name;
    String position;
    String phone;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

    public Employee(String first_name, String last_name, String position, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.phone = phone;
    }

    public Employee(int id, String first_name, String last_name, String position, String phone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfirst_name() {
        return first_name;
    }

    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getlast_name() {
        return last_name;
    }

    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}