package com.bjsxt.pojo;

public class Production {
    private int id;
    private String name;

    public Production() {
    }

    public Production(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
