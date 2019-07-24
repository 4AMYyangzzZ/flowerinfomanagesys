package com.bjsxt.service.impl;

import com.bjsxt.mapper.FlowerMapper;
import com.bjsxt.mapper.ProductionMapper;
import com.bjsxt.pojo.Production;
import com.bjsxt.service.ProductionService;
import com.bjsxt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productionService")
public class ProductionServiceImpl implements ProductionService {
//    private SqlSession sqlSession= MybatisUtil.getSqlSeesion();
//    private ProductionMapper productionMapper= sqlSession.getMapper(ProductionMapper.class);
    @Autowired
    private ProductionMapper productionMapper;

    public ProductionMapper getProductionMapper() {
        return productionMapper;
    }

    public void setProductionMapper(ProductionMapper productionMapper) {
        this.productionMapper = productionMapper;
    }

    @Override
    public List<Production> findAll() {
        return productionMapper.findAll();
    }
}
