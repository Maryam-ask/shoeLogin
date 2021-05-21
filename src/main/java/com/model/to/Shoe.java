package com.model.to;

/**
 * Created by Maryam Askari
 * Date: 5/21/2021
 * Time: 6:17 PM
 * Project: IntelliJ IDEA
 */
public class Shoe {
    private int id;
    private String name;
    private String color;
    private int size;
    private String brand;
    private String type;
    private String prise;

    public Shoe(){}

    public Shoe(int id, String name, String color, int size, String brand, String type, String prise) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.type = type;
        this.prise = prise;
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

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }
}
