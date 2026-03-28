package com.aegis.user.service.impl;

import com.aegis.user.dao.UserMapper;
import com.aegis.user.model.common.PageResult;
import com.aegis.user.model.dto.UserDTO;
import com.aegis.user.model.entity.UserEntity;
import com.aegis.user.model.vo.UserVO;
import com.aegis.user.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户业务逻辑实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean createUser(UserDTO userDTO) {
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(userDTO, entity);
        entity.setCreateTime(LocalDateTime.now());
        entity.setUpdateTime(LocalDateTime.now());
        return userMapper.insert(entity) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new IllegalArgumentException("更新时用户ID不能为空");
        }
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(userDTO, entity);
        entity.setUpdateTime(LocalDateTime.now());
        return userMapper.updateById(entity) > 0;
    }

    @Override
    public UserVO getUserById(Long id) {
        UserEntity entity = userMapper.selectById(id);
        if (entity == null) {
            return null;
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }

    @Override
    public PageResult<UserVO> pageUsers(long current, long size) {
        Page<UserEntity> pageParam = new Page<>(current, size);
        Page<UserEntity> page = userMapper.selectPage(pageParam, null);
        
        List<UserVO> voList = page.getRecords().stream().map(entity -> {
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(entity, vo);
            return vo;
        }).collect(Collectors.toList());

        PageResult<UserVO> result = new PageResult<>();
        result.setTotal(page.getTotal());
        result.setRecords(voList);
        return result;
    }
}