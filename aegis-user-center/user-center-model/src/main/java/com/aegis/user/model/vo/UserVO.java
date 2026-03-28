package com.aegis.user.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户视图对象 (用于返回数据)
 */
@Data
public class UserVO {
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}