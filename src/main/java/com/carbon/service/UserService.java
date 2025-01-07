package com.carbon.service;

import com.carbon.model.dto.UserRegisterRequest;
import com.carbon.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-01-07 20:01:56
*/
public interface UserService extends IService<User> {


    long userRegister(UserRegisterRequest userRegisterRequest);

}
