package com.youyuan.mp.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义公共字段填充处理器
 * @date 2019/4/25 10:03
 */
public class MyMetaObjectHandler extends MetaObjectHandler {

    /**
     * 插入操作自动填充
     * @param metaObject
     */
    public void insertFill(MetaObject metaObject) {
        //获取原数据对象属性值(需要自动填充的属性)
        String name = (String) getFieldValByName("name", metaObject);
        if (StringUtils.isBlank(name)){
            setFieldValByName("name","北京",metaObject);
        }
    }

    /**
     * 更新操作自动填充
     * @param metaObject
     */
    public void updateFill(MetaObject metaObject) {
        //获取自动填充字段属性值(需要自动填充的属性，标记为@TableFiled(fill=Fieldfill.INSERT_UPDATE))
        String name= (String) getFieldValByName("name",metaObject);
        if (StringUtils.isBlank(name)){
            setFieldValByName("name","上海",metaObject);
        }
    }
}
