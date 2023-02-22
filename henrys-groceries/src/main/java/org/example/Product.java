package org.example;
public enum Product {
    SOUP("soup", "tin", 0.65),
    BREAD("bread", "loaf", 0.8),
    MILK("milk", "bottle", 1.30),
    APPLE("apple", "single", 0.1);
    private String name;
    private String unit;
    private double cost;

    private Product(String name, String unit, double cost) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
