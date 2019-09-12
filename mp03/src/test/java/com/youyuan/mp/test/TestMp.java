package com.youyuan.mp.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author zhangyu
 * @version 1.0
 * @description 基于java 代码生成器
 * @date 2019/4/23 10:36
 */
public class TestMp {

    @Test
    public void testGenerator(){
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true) //是否支持AR模式
                .setAuthor("zhangyu") //作者
                .setOutputDir("E:\\Workspaces\\mp03\\src\\main\\java") //生成路径
                .setFileOverride(true)//文件覆盖
                .setServiceName("%sService") //设置生成的service接口名首字母是否为I
                .setIdType(IdType.AUTO); //主键策略

        //配置数据源
        DataSourceConfig dbConfig=new DataSourceConfig();
        dbConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("123456");

        //策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) // 全局大写命名
                .setDbColumnUnderline(true) //表名 字段名 是否使用下滑线命名
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setInclude("tbl_employee") //生成的表
                .setTablePrefix("tbl_"); // 表前缀

        //包配置
        PackageConfig packageConfig=new PackageConfig();
        packageConfig.setParent("com.youyuan.mp") //配置父包
            .setMapper("mapper") //配置mapper接口所在的包
            .setEntity("beans")  //配置实体所在的包
            .setService("service") //配置service所在的包
            .setController("controller"); //配置controller所在的包

        //整合配置
        AutoGenerator autoGenerator=new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dbConfig)
                .setStrategy(stConfig)
                .setPackageInfo(packageConfig);
        autoGenerator.execute(); //执行
    }

}
