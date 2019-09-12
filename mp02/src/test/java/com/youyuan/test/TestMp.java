package com.youyuan.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youyuan.mp.beans.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 测试类
 * @date 2019/4/22 18:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp {

    @Test
    public void testActiveRecordInsert(){
        try {
            Employee employee = new Employee(null, "刘老师", "liu@youyuan.com", 1, 33);
            System.out.println("employee:"+employee);
            boolean insertResult = employee.insert();
            System.out.println("AR测试保存结果:"+insertResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testActiveRecordUpdate(){
        Employee employee = new Employee(13, "谢老师", "xielaoshi@youyuan.com", 0, 49);
        boolean updateResult = employee.updateById();
        System.out.println("updateResult:"+updateResult);
    }

    @Test
    public void testActiveRecordSelect(){
//        Employee employee=new Employee();
//        Employee result = employee.selectById(13);
//        System.out.println(result);

//        Employee employee=new Employee();
//        List<Employee> employees = employee.selectAll();
//        System.out.println(employees);

//        Employee employee=new Employee();
//        List<Employee> employees = employee.selectList(new EntityWrapper().like("last_name", "Tom"));
//        System.out.println(employees);

        Employee employee=new Employee();
        int gender = employee.selectCount(new EntityWrapper().eq("gender", 1));
        System.out.println(gender);
    }

    @Test
    public void testActiveRecordDelete(){
//        Employee employee=new Employee();
//        boolean result = employee.deleteById(14);
//        System.out.println(result);

        Employee employee=new Employee();
        boolean delete = employee.delete(new EntityWrapper().like("last_name", "老"));
        System.out.println(delete);
    }

    @Test
    public void testSelectPage(){
        Employee employee=new Employee();
        Page<Employee> employeePage = employee.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>()
                .like("last_name", "T"));
        List<Employee> records = employeePage.getRecords();
        System.out.println(records);
    }

}
