package com.aegis.user.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户数据传输对象 (用于接收请求数据)
 */
@Data
public class UserDTO {
    
    /**
     * 主键ID (更新时必须)
     */
    private Long id;
    
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 手机号
     */
    private String phone;
}