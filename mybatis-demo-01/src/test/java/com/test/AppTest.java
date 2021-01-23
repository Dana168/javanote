package com.test;

import static org.junit.Assert.assertTrue;

import com.test.mapper.UserMapper;
import com.test.pojo.User;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.getAll();
        for (User user : all) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void  insertTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User woowoow = new User(6, "woowoow", "fdsdf");
        mapper.addUser(woowoow);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User query = mapper.query(6);
        System.out.println(query);
        sqlSession.close();
    }

    @Test
    public void  delUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delUser(1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(6,"eee","432223"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUser("李");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
