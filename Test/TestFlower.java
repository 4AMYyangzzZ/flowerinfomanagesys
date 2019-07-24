import com.bjsxt.mapper.FlowerMapper;
import com.bjsxt.pojo.Flower;
import com.bjsxt.service.FlowerService;
import com.bjsxt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestFlower {
    SqlSession sqlSession=null;
    @Before
    public void before(){
        System.out.println("--before--");
        sqlSession= MybatisUtil.getSqlSeesion();
    }
    @After
    public void after(){
        System.out.println("--after--");
        if (sqlSession!=null){
            sqlSession.close();
        }
    }
    @Test
    public void testFindAll(){
        FlowerMapper flowerMapper=sqlSession.getMapper(FlowerMapper.class);
        List<Flower> all = flowerMapper.findAll();
        for (Flower flower : all) {
            System.out.println(flower);
        }
        sqlSession.commit();
    }
    @Test
    public void testInsert(){
//        FlowerMapper flowerMapper=sqlSession.getMapper(FlowerMapper.class);
//        Flower flower=new Flower("玫瑰花",99,"china");
//        flowerMapper.save(flower);
//        sqlSession.commit();
    }
    @Test
    public void testFindByCon(){
        FlowerMapper flowerMapper=sqlSession.getMapper(FlowerMapper.class);
        Map<String,Object>map=new HashMap<>();
       // map.put("name","矮");
       map.put("productionId",4);
        List<Flower> all = flowerMapper.findByCon(map);
        System.out.println(all);
        sqlSession.commit();
    }

}
