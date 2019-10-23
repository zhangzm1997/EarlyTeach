package com.mbyte.easy.admin.mapper;

import com.mbyte.easy.admin.entity.StudentCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbyte.easy.admin.entity.StudentCourseVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 黄润宣
 * @since 2019-04-26
 */
public interface StudentCourseMapper extends BaseMapper<StudentCourse> {

    /* * @Author 闫志行
     * @Description //查询登录学生所选的所有课程
     * @Param [studentCourse]
     * @return
     * @return: java.util.List<com.mbyte.easy.admin.entity.StudentCourseVO>
     **/
    @Select("<script>" +

            " SELECT " +
    "t_student_course.is_buy," +
    "t_student_course.id," +
     "t_student_course.student_num,"+
    "t_student_course.is_reserve," +
    " t_course.`subject`, " +
    "t_course.course_infor," +
    "t_student_course.is_check," +
    "t_course.course_time_period," +
    "t_course.teacher_num," +
    "t_course.class_time," +
    "t_course.class_room," +
    "t_course.num_limit," +
    "t_course.age_limit," +
    "t_course.start_time," +
    "t_course.course_fee" +
            " FROM " +
    "t_course ," +
    "t_student_course" +
           " WHERE " +
    "t_course.id = t_student_course.course_id AND " +
    "t_student_course.student_num = '${studentNum}' " +
            "</script>")
    List<StudentCourseVO> selectAllStudentCouse (StudentCourse studentNum);
}
