package com.mbyte.easy.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
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
@TableName("t_student_course")
public class StudentCourse extends BaseEntity {

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


}
