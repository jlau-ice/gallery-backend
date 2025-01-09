package com.carbon.service;

import com.carbon.model.dto.UserLoginRequest;
import com.carbon.model.dto.UserRegisterRequest;
import com.carbon.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon.model.vo.UserLoginVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-01-07 20:01:56
*/
@Service
public interface UserService extends IService<User> {


    long userRegister(UserRegisterRequest userRegisterRequest);


    UserLoginVO userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request);

    UserLoginVO getLoginUserVO(User user);

    User getLoginUser(HttpServletRequest request);

    void userLogout(HttpServletRequest request);

    String getEncryptPassword(String password);

    String getDefaultUserName(String userAccount);

}
