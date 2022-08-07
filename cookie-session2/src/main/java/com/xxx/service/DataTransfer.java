package com.xxx.service;

import com.xxx.mapper.userMapper;
import com.xxx.pojo.brand;
import com.xxx.pojo.user;
import com.xxx.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public class DataTransfer {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<brand> selectAll()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        List<brand> brands = mapper.selectAll();
        return brands;

    }

    public user selectUserAll(String account,String password)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user user = mapper.selectUser(account, password);
        return user;

    }

    public void insertUser(String account,String password1)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.insertUser(account,password1);
        sqlSession.commit();
    }

    public user selectByAccount(String account)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user user = mapper.selectByAccount(account);
        return user;
    }



}
