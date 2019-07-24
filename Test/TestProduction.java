import com.bjsxt.mapper.ProductionMapper;
import com.bjsxt.pojo.Production;
import com.bjsxt.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestProduction {
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
        ProductionMapper mapper = sqlSession.getMapper(ProductionMapper.class);
        List<Production> all = mapper.findAll();
        System.out.println(all);
    }
}
