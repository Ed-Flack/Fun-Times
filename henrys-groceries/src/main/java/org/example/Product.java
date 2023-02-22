package org.example;

public enum Product {
    SOUP("soup", "tin", 0.65),
    BREAD("bread", "loaf", 0.8),
    MILK("milk", "bottle", 1.30),
    APPLE("apple", "single", 0.1);
    private final String name;
    private final String unit;
    private final double cost;

    Product(String name, String unit, double cost) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getCost() {
        return cost;
    }
}
