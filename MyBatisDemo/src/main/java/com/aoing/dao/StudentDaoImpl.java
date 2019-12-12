package com.aoing.dao;

import com.aoing.bean.Student;
import com.aoing.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentDaoImpl implements StudentDao {

    private SqlSession sqlSession;

    @Override
    public void insertStudent(Student student) {
        try{
            /*//加载主配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");

            //创建SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //创建SqlSession对象
            sqlSession = sqlSessionFactory.openSession();*/

            sqlSession = MyBatisUtils.getSqlSession();

            //进行增删改查
            sqlSession.insert("insertStudent",student);

            //提交事务
            sqlSession.commit();
        } finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }

    }
}
