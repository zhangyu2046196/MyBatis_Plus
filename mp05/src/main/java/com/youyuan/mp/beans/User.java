package com.youyuan.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 用户实体类信息
 * @date 2019/4/24 11:22
 */
public class User implements Serializable {
    private static final long serialVersionUID = -506402056974404907L;

    private Integer id;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;
    @TableLogic  //标记为逻辑删除字段
    private Integer logicFlag;

    public User() {
    }

    public User(Integer id, String name, Integer logicFlag) {
        this.id = id;
        this.name = name;
        this.logicFlag = logicFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logicFlag=" + logicFlag +
                '}';
    }
}
