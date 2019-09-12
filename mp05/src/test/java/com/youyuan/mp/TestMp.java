package com.youyuan.mp;

import com.youyuan.mp.beans.User;
import com.youyuan.mp.mapper.EmployeeMapper;
import com.youyuan.mp.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangyu
 * @version 1.0
 * @description
 * @date 2019/4/24 10:59
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testAutoSqlInjector(){
        employeeMapper.deleteAll();
    }

    @Test
    public void testLogicInjector(){
        //userMapper.deleteById(1);

        User user = userMapper.selectById(1);
        System.out.println("user:"+user);
    }

    @Test
    public void testMetaObjectHandler(){
//        User user = new User(null, null,1);
//        userMapper.insert(user);

        User user=new User(7,null,1);
        userMapper.updateById(user);
    }

}
