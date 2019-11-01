package com.mbyte.easy.admin.service.impl;

import com.mbyte.easy.admin.entity.Student;
import com.mbyte.easy.admin.mapper.StudentMapper;
import com.mbyte.easy.admin.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张泽敏
 * @since 2019-04-26
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
