package com.bjsxt.pojo;

public class Flower {
    private int id;
    private String name;
    private float price;
    private int productionId;
    private Production production;
    private String flowerImage;
    private String realName;



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

    public Flower(String name, float price, int productionId, String flowerImage, String realName) {
        this.name = name;
        this.price = price;
        this.productionId = productionId;
        this.flowerImage = flowerImage;
        this.realName = realName;
    }

    public Flower(int id, String name, float price, int productionId, Production production) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productionId = productionId;
        this.production = production;
    }

    public Flower(String name, float price, int productionId, String flowerImage) {
        this.name = name;
        this.price = price;
        this.productionId = productionId;
        this.flowerImage = flowerImage;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getFlowerImage() {
        return flowerImage;
    }

    public void setFlowerImage(String flowerImage) {
        this.flowerImage = flowerImage;
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
                ", flowerImage='" + flowerImage + '\'' +
                ", realName='" + realName + '\'' +
                '}';
    }
}
