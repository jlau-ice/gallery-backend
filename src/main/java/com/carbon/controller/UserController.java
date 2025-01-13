package com.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.carbon.annotation.AuthCheck;
import com.carbon.common.BaseResponse;
import com.carbon.common.Constant;
import com.carbon.common.ResultUtils;
import com.carbon.model.dto.user.*;
import com.carbon.model.entity.User;
import com.carbon.model.vo.UserLoginVO;
import com.carbon.model.vo.UserVO;
import com.carbon.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @PostMapping("/add")
    @AuthCheck(mustRole = Constant.ADMIN)
    public BaseResponse<Long> addUser(@RequestBody UserAddRequest entity) {
        return ResultUtils.success(userService.addUser(entity));
    }


    @GetMapping("/getUserVoById")
    public BaseResponse<UserVO> getUserVoById(@RequestParam("id") Long id) {
        return ResultUtils.success(userService.getUserVoById(id));
    }

    @GetMapping("/getUserById")
    @AuthCheck(mustRole = Constant.ADMIN)
    public BaseResponse<User> getUserById(@RequestParam("id") Long id) {
        return ResultUtils.success(userService.getUserById(id));
    }

    @PostMapping("/update")
    public BaseResponse<String> updateUser(@RequestBody UserUpdateRequest entity) {
        User user = new User();
        BeanUtils.copyProperties(entity, user);
        userService.updateById(user);
        return ResultUtils.success();
    }

    @PostMapping("/delete")
    @AuthCheck(mustRole = Constant.ADMIN)
    public BaseResponse<Boolean> deleteUser(@RequestParam("id") Long id) {
        return ResultUtils.success(userService.removeUser(id));
    }

    @PostMapping("/list")
    @AuthCheck(mustRole = Constant.ADMIN)
    public BaseResponse<Page<UserVO>> getUserList(@RequestBody UserQueryRequest entity) {
        return ResultUtils.success(userService.getList(entity));
    }

}


