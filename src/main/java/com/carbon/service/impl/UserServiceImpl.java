package com.carbon.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon.exception.BusinessException;
import com.carbon.exception.ErrorCode;
import com.carbon.exception.ThrowUtils;
import com.carbon.model.dto.UserRegisterRequest;
import com.carbon.model.entity.User;
import com.carbon.service.UserService;
import com.carbon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2025-01-07 20:01:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public long userRegister(UserRegisterRequest userRegisterRequest) {
        // 1. 校验参数
        ThrowUtils.throwIf(StrUtil.hasBlank(
                        userRegisterRequest.getUserAccount(),
                        userRegisterRequest.getUserPassword(),
                        userRegisterRequest.getCheckPassword()),
                ErrorCode.PARAMS_ERROR,
                "参数为空");
        ThrowUtils.throwIf((userRegisterRequest.getUserPassword().length() < 8 || userRegisterRequest.getCheckPassword().length() < 8),
                ErrorCode.PARAMS_ERROR, "密码长度不能小于8位");

        ThrowUtils.throwIf(!userRegisterRequest.getUserPassword().equals(userRegisterRequest.getCheckPassword()),
                ErrorCode.PARAMS_ERROR,
                "两次输入的密码不一致");
        // 2. 重复数据账号

        // 3. 加密

        // 4. 插入数据到数据库中
        return 0;
    }
}




