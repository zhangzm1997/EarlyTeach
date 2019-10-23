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
 * @author 黄润宣
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_income")
public class Income extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 签到人数
     */
    private Integer checkNum;

    /**
     * 到课率
     */
    private String checkPer;

    /**
     * 销量
     */
    private Long sell;

    /**
     * 课程收入
     */
    private String courseIncome;


}
