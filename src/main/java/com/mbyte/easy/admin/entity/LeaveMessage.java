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
 * @author 张泽敏
 * @since 2019-04-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_leave_message")
public class LeaveMessage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 留言时间
     */
    private LocalDateTime createtime;

    /**
     * 留言人（学号/工号）
     */
    private String nums;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 回复时间
     */
    private LocalDateTime updatetime;

    /**
     * 回复人（学号/工号）
     */
    private String num;

    /**
     * 回复内容
     */
    private String reply;


}
