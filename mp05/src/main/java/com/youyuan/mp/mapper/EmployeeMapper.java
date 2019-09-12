package com.youyuan.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.youyuan.mp.beans.Employee;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangyu
 * @since 2019-04-23
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    void deleteAll();

}
