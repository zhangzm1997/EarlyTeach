package com.mbyte.easy.admin.service.impl;

import com.mbyte.easy.admin.entity.StudentCourse;
import com.mbyte.easy.admin.entity.StudentCourseVO;
import com.mbyte.easy.admin.mapper.StudentCourseMapper;
import com.mbyte.easy.admin.service.IStudentCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 黄润宣
 * @since 2019-04-26
 */
@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse> implements IStudentCourseService {

    @Resource
    StudentCourseMapper studentCourseMapper;

    //学生查询自己的课程信息
    @Override
    public List<StudentCourseVO> selectAllStudentCouse(StudentCourse studentNum) {
        return studentCourseMapper.selectAllStudentCouse(studentNum);
    }
}
