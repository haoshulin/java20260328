package com.aegis.user.service;

import com.aegis.user.model.common.PageResult;
import com.aegis.user.model.dto.UserDTO;
import com.aegis.user.model.vo.UserVO;

/**
 * 用户业务逻辑接口
 */
public interface UserService {
    
    /**
     * 新增用户
     * @param userDTO 用户信息
     * @return 是否成功
     */
    boolean createUser(UserDTO userDTO);
    
    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否成功
     */
    boolean deleteUser(Long id);
    
    /**
     * 修改用户
     * @param userDTO 用户信息
     * @return 是否成功
     */
    boolean updateUser(UserDTO userDTO);
    
    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户视图对象
     */
    UserVO getUserById(Long id);
    
    /**
     * 分页查询用户
     * @param current 当前页
     * @param size 每页大小
     * @return 分页结果
     */
    PageResult<UserVO> pageUsers(long current, long size);
}