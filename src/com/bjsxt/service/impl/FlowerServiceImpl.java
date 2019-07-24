package com.bjsxt.service.impl;

import com.bjsxt.mapper.FlowerMapper;
import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("flowerService")
public class FlowerServiceImpl implements FlowerService {
//    private SqlSession sqlSession=MybatisUtil.getSqlSeesion();
//    private FlowerMapper flowerMapper= sqlSession.getMapper(FlowerMapper.class);
    @Autowired
    private FlowerMapper flowerMapper;

    public FlowerMapper getFlowerMapper() {
        return flowerMapper;
    }

    public void setFlowerMapper(FlowerMapper flowerMapper) {
        this.flowerMapper = flowerMapper;
    }

    @Override
    public List<Flower> findAll() {
        return flowerMapper.findAll();
    }

    @Override
    public boolean addFlower(Flower flower) {
        int save = flowerMapper.save(flower);
        //sqlSession.commit();
        return save>0;
    }

    @Override
    public List<Flower> findByCon(String name, int productionId) {
        Map<String,Object>map=new HashMap<>();
        map.put("name",name);
        map.put("productionId",productionId);
        List<Flower>list=flowerMapper.findByCon(map);
        return list;
    }

    @Override
    public List<Flower> findImageById(int id) {
        List<Flower>list=flowerMapper.findImageById(id);
        return list;
    }
}
