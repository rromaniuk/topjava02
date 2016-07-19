package ru.javawebinar.topjava.to;

import ru.javawebinar.topjava.util.AbstractUser;

import java.io.Serializable;

public class UserTo implements AbstractUser, Serializable {
    protected int id;

    public UserTo() {
    }

    public UserTo(int id, String name, String email, int caloriesPerDay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.caloriesPerDay = caloriesPerDay;
    }

    protected String name;

    protected String email;

    protected String password;

    protected int caloriesPerDay = 2000;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = (id == null ? 0 : id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
