package com.model.to;

/**
 * Created by Maryam Askari
 * Date: 5/21/2021
 * Time: 6:17 PM
 * Project: IntelliJ IDEA
 */
public class Shoe {
    private long id;
    private String name;
    private String color;
    private int size;
    private String brand;
    private String type;
    private double prise;

    public Shoe(){}

    public Shoe(int id, String name, String color, int size, String brand, String type, double prise) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.type = type;
        this.prise = prise;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }
}
