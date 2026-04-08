package com.aegis.user.web;

import com.aegis.user.api.UserFeignApi;
import com.aegis.user.model.common.PageResult;
import com.aegis.user.model.common.Result;
import com.aegis.user.model.dto.UserDTO;
import com.aegis.user.model.vo.UserVO;
import com.aegis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户接口控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController implements UserFeignApi {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param userDTO 用户信息
     * @return 结果
     */
    @PostMapping
    public Result<Boolean> createUser(@Validated @RequestBody UserDTO userDTO) {
        return Result.success(userService.createUser(userDTO));
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteUser(@PathVariable("id") Long id) {
        return Result.success(userService.deleteUser(id));
    }

    /**
     * 修改用户
     * @param userDTO 用户信息
     * @return 结果
     */
    @PutMapping
    public Result<Boolean> updateUser(@Validated @RequestBody UserDTO userDTO) {
        return Result.success(userService.updateUser(userDTO));
    }

    /**
     * 根据ID获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    @GetMapping("/{id}")
    public Result<UserVO> getUserById(@PathVariable("id") Long id) {
        UserVO user = userService.getUserById(id);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error(404, "用户不存在");
    }

    /**
     * 分页查询用户
     * @param current 当前页
     * @param size 每页大小
     * @return 分页结果
     */
    @GetMapping("/page")
    public Result<PageResult<UserVO>> pageUsers(
            @RequestParam(name = "current", defaultValue = "1") long current,
            @RequestParam(name = "size", defaultValue = "10") long size) {
        return Result.success(userService.pageUsers(current, size));
    }
}