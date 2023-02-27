package com.powernode.mybatis.test;

import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {
11111
    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = null;
        try {

            // 开启会话，底层会开启事务
            sqlSession = SqlSessionUtil.openSession();
            //执行sql语句，处理相关业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            // 执行到这里，没有出现异常，提交事务
            sqlSession.commit();
        } catch (Exception e) {
            // 最好回滚事务
            if (sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
            ;
        } finally {
            //关闭会话
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            // 开启会话，底层会开启事务
            sqlSession = build.openSession();
            //执行sql语句，处理相关业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            // 执行到这里，没有出现异常，提交事务
            sqlSession.commit();
        } catch (Exception e) {
            // 最好回滚事务
            if (sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
            ;
        } finally {
            //关闭会话
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
