package com.mbyte.easy.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 黄润宣
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_course")
public class Course extends BaseEntity {

    private static final long serialVersionUID = 1L;

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
