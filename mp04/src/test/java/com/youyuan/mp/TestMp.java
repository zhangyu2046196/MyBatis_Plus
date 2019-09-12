package com.youyuan.mp;

import com.baomidou.mybatisplus.plugins.Page;
import com.youyuan.mp.beans.Employee;
import com.youyuan.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description mybatis-plus插件测试信息
 * @date 2019/4/23 20:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testSelectPage(){
        Page<Employee> page=new Page<Employee>(1,1);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        System.out.println("employees:"+employees);
        System.out.println("===========分页结果信息=============");
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("当前页码："+page.getCurrent());
        System.out.println("每页显示条数："+page.getSize());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void testSqlExplain(){
        employeeMapper.delete(null);
    }

    @Test
    public void testPerformans(){
        Employee employee=new Employee(null,"jakc","jk@youyuan.com","1",39,1);
        employee.insert();
    }

    @Test
    public void testVersion(){
        Employee employee=new Employee(21,"Tom and Jer","tj@youyuan.com","1",52,2);
        employee.updateById();
    }

}
