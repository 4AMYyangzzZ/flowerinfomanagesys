package com.bjsxt.pojo;

public class Flower {
    private int id;
    private String name;
    private float price;
    private int productionId;
    private Production production;

    public Flower() {
    }

    public Flower(String name, float price, int productionId) {
        this.name = name;
        this.price = price;
        this.productionId = productionId;
    }

    public Flower(String name, float price, int productionId, Production production) {
        this.name = name;
        this.price = price;
        this.productionId = productionId;
        this.production = production;
    }

    public Flower(int id, String name, float price, int productionId, Production production) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productionId = productionId;
        this.production = production;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getProductionId() {
        return productionId;
    }

    public void setProductionId(int productionId) {
        this.productionId = productionId;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productionId=" + productionId +
                ", production=" + production +
                '}';
    }
}
