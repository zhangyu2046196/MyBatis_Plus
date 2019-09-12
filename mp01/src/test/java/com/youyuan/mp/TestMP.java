package com.youyuan.mp;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.youyuan.mp.mapper.EmployeeMapper;
import com.youyuan.mp.beans.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyu
 * @version 1.0
 * @description  测试
 * @date 2019/4/17 22:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMP {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = context.getBean(DataSource.class);
        System.out.println("dataSource:"+dataSource);
        Connection connection = dataSource.getConnection();
        System.out.println("connection:"+connection);
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee(null, "广东", null, 2, 89);
        //insert方法，如果实体的属性为null，则实体属性对应的数据库表的字段不会出现在sql语句中
        //employeeMapper.insert(employee);
        //insertAllColumn 中实体的所有属性对应的数据表字段都会出现在sql语句中且为空的属性对应的数据库字段也为空
        employeeMapper.insertAllColumn(employee);
        System.out.println("employee:"+employee);
    }

    @Test
    public void testUpdate(){
        //updateById方法 主键id不能为空，如果实体属性为空，则对应的数据库表字段不被修改,并且不会出现在sql语句中
        //updateAllColumnById  主键id不能为空 实体中所有属性对应的数据库表字段都会出现在sql语句中,且为空的属性对应的数据库字段也为空
        Employee employee = new Employee(9, "广东", "ouyouo.com", 2,null);
        //employeeMapper.updateById(employee);
        employeeMapper.updateAllColumnById(employee);
    }

    @Test
    public void testSelect(){
        //根据主键查询
//        Employee employee = employeeMapper.selectById(8);
//        System.out.println("employee:"+employee);

        //根据不为空的属性查询，并且只查询出一条数据，如果有多条数据符合条件，则查询报错
//        Employee employee = employeeMapper.selectOne(new Employee(8, null, null, 2, null));
//        System.out.println("employee:"+employee);

        //根据主键批量查询
        //List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 6, 3, 9));
        //System.out.println("employees:"+employees);

        //封装map查询参数查询，此处map的key是数据库字段名
//        Map<String,Object> columnMap=new HashMap<String,Object>();
//        columnMap.put("last_name","Tom");
//        columnMap.put("gender",1);
//        List<Employee> emps = employeeMapper.selectByMap(columnMap);
//        System.out.println("empsMap:"+emps);

        //分页查询  Page或RowBounds都是内存分页，一次全部查询
        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 2), null);
        System.out.println("第二页:"+employees);
        employees = employeeMapper.selectPage(new Page<>(3, 2), null);
        System.out.println("第三页:"+employees);
    }

    @Test
    public void testDelete(){
        //根据主键删除
//        employeeMapper.deleteById(9);

        //根据条件删除  map的key必须是数据库表字段名
//        Map<String,Object> columnMap=new HashMap<String,Object>();
//        columnMap.put("last_name","广东");
//        employeeMapper.deleteByMap(columnMap);

        //根据主键批量删除
        employeeMapper.deleteBatchIds(Arrays.asList(5,6));
    }

    @Test
    public void testEntityWrapperSelect(){
        //测试条件构造器EntityWrapper
        //目标：查询tbl_employee表中年龄在18到50岁且男性和名字是Tom的员工，需要分页查询
        //selectPage用法
//        List<Employee> employees=employeeMapper.selectPage(new Page<Employee>(1,2),new EntityWrapper<Employee>()
//            .between("age",18,50)
//            .eq("gender",1)
//            .eq("last_name","Tom"));
//        System.out.println("第一页："+employees);
//        employees=employeeMapper.selectPage(new Page<Employee>(2,2),new EntityWrapper<Employee>()
//                .between("age",18,50)
//                .eq("gender",1)
//                .eq("last_name","Tom"));
//        System.out.println("第二页："+employees);


        //selectList用法
        //目标：查询性别为男，名字包含Tom或邮箱包含Tom
        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 1)
                .andNew()
                .like("last_name", "Tom")
                .or() //gender = ? AND last_name LIKE ? OR email LIKE ?
                //.orNew() //(gender = ? AND last_name LIKE ?) OR (email LIKE ?)
                .like("email", "Tom"));
        System.out.println("查询结果employees:"+employees);
    }

    @Test
    public void testEntityWrapperUpdate(){
        //条件构造器修改
        //目标：修改名字为Tom,年龄为29的用户，名字改成苍老师 性别改成女
        Integer update = employeeMapper.update(new Employee(null, "苍老师", null, 0, null), new EntityWrapper<Employee>()
                .eq("last_name", "Tom")
                .eq("age", 29));
    }

    @Test
    public void testEntityWrapperDelete(){
        //条件构造器删除
        //目标：删除名称包含老师、性别女、年龄29的用户
        Integer delete = employeeMapper.delete(new EntityWrapper<Employee>()
                .like("last_name", "老师")
                .eq("gender", 0)
                .eq("age", 29));
    }

    @Test
    public void testEntityWrapperInsert(){
        //条件构造器
        //保存记录
        Integer jendi = employeeMapper.insert(new Employee(null, "jendi", "jendi@youyuan.com", 1, 32));
    }

    @Test
    public void testConditionSelect(){
        List list = employeeMapper.selectPage(new Page<Employee>(1, 2), Condition.create()
                .like("last_name", "Tom"));
        System.out.println("list:"+list);
    }

}
