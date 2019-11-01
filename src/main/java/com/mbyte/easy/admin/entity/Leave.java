package com.mbyte.easy.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 张泽敏
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_leave")
public class Leave extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 请假学生学号
     */
    private String studentNum;

    /**
     * 请假原因
     */
    private String leaveReason;

    /**
     * 请假课程id
     */
    private Long courseId;

    /**
     * 请假课程时间
     */
    private String leaveTime;

    /**
     * 该课程请假次数
     */
    private Integer leaveNum;

    /**
     * 请假结果
     */
    private Integer leaveResult;

    /**
     * 课程老师工号
     */
    private String leaveTeacherNum;

    /**
     * 调课课程id
     */
    private Long changeCourseId;

    /**
     * 调课课程时间
     */
    private String changeTime;

    /**
     * 调课老师工号
     */
    private String changeTeacherNum;

    /**
     * 调课结果(0失败1成功)
     */
    private Integer changeResult;


}
