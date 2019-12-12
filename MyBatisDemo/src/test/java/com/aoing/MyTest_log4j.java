package com.aoing;

import com.aoing.bean.Student;
import com.aoing.dao.StudentDao;
import com.aoing.dao.StudentDaoImpl;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;


public class MyTest_log4j
{
    private static Logger logger = Logger.getLogger(MyTest_log4j.class);
    private StudentDao dao;

    @Before
    public void before(){
        dao = new StudentDaoImpl();
    }

    @Test
    public void testInsert()
    {
        Student student = new Student("小明", 24, 90);
        dao.insertStudent(student);
        logger.info("插入数据库");
    }
}
