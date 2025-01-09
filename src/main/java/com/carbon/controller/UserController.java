package com.carbon.controller;

import com.carbon.annotation.AuthCheck;
import com.carbon.common.BaseResponse;
import com.carbon.common.ResultUtils;
import com.carbon.model.dto.UserLoginRequest;
import com.carbon.model.dto.UserRegisterRequest;
import com.carbon.model.vo.UserLoginVO;
import com.carbon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest entity) {
        return ResultUtils.success(userService.userRegister(entity));
    }

    @PostMapping("/login")
    public BaseResponse<UserLoginVO> userLogin(@RequestBody UserLoginRequest entity, HttpServletRequest request) {
        return ResultUtils.success(userService.userLogin(entity, request));
    }


    @GetMapping("/getUserLogin")
    public BaseResponse<UserLoginVO> getUserLogin(HttpServletRequest request) {
        return ResultUtils.success(userService.getLoginUserVO(userService.getLoginUser(request)));
    }

    @PostMapping("/logout")
    public BaseResponse<String> userLogout(HttpServletRequest request) {
        userService.userLogout(request);
        return ResultUtils.success();
    }

}


