package com.bjsxt.mapper;

import com.bjsxt.pojo.Flower;

import java.util.List;
import java.util.Map;

public interface FlowerMapper {
    public List<Flower> findAll();
    public int save(Flower flower);
    List<Flower> findByCon(Map<String, Object> map);
}
