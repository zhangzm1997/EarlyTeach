package com.mbyte.easy.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName StudentCourseVO
 * @Description TODO
 * @Author Administrator  张泽敏
 * @date 2019/5/5 20:40
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StudentCourseVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 学号
     */
    private String studentNum;

    /**
     * 预约
     */
    private String isReserve;

    /**
     * 购买
     */
    private String isBuy;

    /**
     * 购买时间
     */
    private LocalDateTime buyTime;

    /**
     * 签到
     */
    private String isCheck;

    /**
     * 名称
     */
    private String subject;

    /**
     * 课程信息录入
     */
    private String courseInfor;

    /**
     * 课程时间
     */
    private String courseTimePeriod;

    /**
     * 职工号
     */
    private String teacherNum;

    /**
     * 上课时间
     */
    private String classTime;

    /**
     * 上课教室
     */
    private String classRoom;

    /**
     * 人数限制
     */
    private Integer numLimit;

    /**
     * 年龄限制
     */
    private String ageLimit;

    /**
     * 开始时间
     */
    private LocalDate startTime;

    /**
     * 课程费用
     */
    private String courseFee;

}
