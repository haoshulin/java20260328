package com.aegis.user.api;

import com.aegis.user.model.common.Result;
import com.aegis.user.model.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务 Feign 接口
 */
@FeignClient(name = "user-center", path = "/api/user")
public interface UserFeignApi {

    /**
     * 根据ID获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    Result<UserVO> getUserById(@PathVariable("id") Long id);
}