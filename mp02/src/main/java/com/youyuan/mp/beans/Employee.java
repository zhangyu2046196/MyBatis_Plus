package com.youyuan.mp.beans;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 员工实体bean与数据库tbl_employee表映射
 * @date 2019/4/17 21:27
 *
 * 属性用基本数据类型的包装类
 *
 * GlobalConfiguration 的全局配置策略配置表的前缀、开启驼峰命名规则(默认是开启的)、表的主键生成策略
 *
 * 注：mybatis-plus的全局配置策略需要注入到MyBatisSqlSessionFactory的属性中去
 *
 */
//@TableName("tbl_employee")
public class Employee extends Model<Employee> implements Serializable{
    private static final long serialVersionUID = 6890351114968749355L;

    //@TableId(type = IdType.AUTO)
    private Integer id;
    //@TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    public Employee() {
    }

    protected Serializable pkVal() {
        return this.id;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
