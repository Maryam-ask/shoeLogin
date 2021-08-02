package com.model.to;

import javafx.beans.property.*;

/**
 * Created by Maryam Askari
 * Date: 6/30/2021
 * Time: 10:19 AM
 * Project: IntelliJ IDEA
 */
public class ShoeProperty {
    private final LongProperty id = new SimpleLongProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty color = new SimpleStringProperty();
    private final IntegerProperty size = new SimpleIntegerProperty();
    private final StringProperty brand = new SimpleStringProperty();
    private final StringProperty type = new SimpleStringProperty();
    private final DoubleProperty prise = new SimpleDoubleProperty();

    private BooleanProperty selectable=new SimpleBooleanProperty(false);



    public long getId() {
        return idProperty().get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        idProperty().set(id);
    }

    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    public String getColor() {
        return colorProperty().get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public void setColor(String color) {
        colorProperty().set(color);
    }

    public int getSize() {
        return sizeProperty().get();
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public void setSize(int size) {
        sizeProperty().set(size);
    }

    public String getBrand() {
        return brandProperty().get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        brandProperty().set(brand);
    }

    public String getType() {
        return typeProperty().get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        typeProperty().set(type);
    }

    public double getPrise() {
        return priseProperty().get();
    }

    public DoubleProperty priseProperty() {
        return prise;
    }

    public void setPrise(double prise) {
        priseProperty().set(prise);
    }

    public boolean isSelectable() {
        return selectableProperty().get();
    }

    public BooleanProperty selectableProperty() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        selectableProperty().set(selectable);
    }
}
