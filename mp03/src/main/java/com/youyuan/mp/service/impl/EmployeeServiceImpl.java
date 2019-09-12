package com.youyuan.mp.service.impl;

import com.youyuan.mp.beans.Employee;
import com.youyuan.mp.mapper.EmployeeMapper;
import com.youyuan.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyu
 * @since 2019-04-23
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
