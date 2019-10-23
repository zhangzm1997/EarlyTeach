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
@TableName("t_student")
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private String studentNum;

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

    /**
     * 出生年月
     */
    private LocalDate born;

    /**
     * 账户余额
     */
    private String balance;


}
