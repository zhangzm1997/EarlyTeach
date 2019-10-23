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
@TableName("t_teacher")
public class Teacher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 职工号
     */
    private String teacherNum;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;


}
