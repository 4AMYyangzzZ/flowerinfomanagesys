package com.bjsxt.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSession sqlSession;
    public static SqlSession getSqlSeesion(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config");
            if (sqlSession==null){
                sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
