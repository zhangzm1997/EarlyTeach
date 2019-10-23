package com.mbyte.easy.admin.service;

import com.mbyte.easy.admin.entity.StudentCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mbyte.easy.admin.entity.StudentCourseVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 黄润宣
 * @since 2019-04-26
 */
public interface IStudentCourseService extends IService<StudentCourse> {
    List<StudentCourseVO> selectAllStudentCouse (StudentCourse studentNum);
}
