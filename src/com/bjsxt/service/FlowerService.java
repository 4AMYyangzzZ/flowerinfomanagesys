package com.bjsxt.service;

import com.bjsxt.pojo.Flower;

import java.util.List;

public interface FlowerService {
    public List<Flower> findAll();
    public boolean addFlower(Flower flower);

    public List<Flower> findByCon(String name, int production);
}
