package com.mbyte.easy.admin.mapper;

import com.mbyte.easy.admin.entity.Leave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbyte.easy.admin.entity.StudentCourse;
import com.mbyte.easy.admin.entity.StudentCourseVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 黄润宣
 * @since 2019-04-27
 */
public interface LeaveMapper extends BaseMapper<Leave> {

//    /* * @Title:
//     * @Description: //TODO
//     * @Author: 闫志行
//     * @Date: 2019/5/7 9:54
//     * @Param
//     * @Return
//     **/
//
//    @Select("<script>" +
//    " SELECT " +
//    " t_leave.id, " +
//    " t_leave.student_num, " +
//    " t_leave.leave_reason, " +
//    " t_leave.course_id, " +
//    " t_leave.leave_num, " +
//    " t_leave.leave_result, " +
//    " t_leave.leave_teacher_num, " +
//    " t_leave.change_course_id, " +
//    " t_leave.change_teacher_num, " +
//    " t_leave.change_result, " +
//    " t_student_course.is_reserve " +
//    " FROM " +
//    " t_student_course , " +
//    " t_leave " +
//    " WHERE " +
//    " t_student_course.course_id = t_leave.course_id AND " +
//    " t_student_course.student_num = t_leave.student_num " +
//            "</script>")
//    List<StudentCourseVO> selectAllStudentCouse (StudentCourse studentNum);

}
