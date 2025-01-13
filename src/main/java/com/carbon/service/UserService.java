package com.carbon.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.carbon.model.dto.user.UserAddRequest;
import com.carbon.model.dto.user.UserLoginRequest;
import com.carbon.model.dto.user.UserQueryRequest;
import com.carbon.model.dto.user.UserRegisterRequest;
import com.carbon.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon.model.vo.UserLoginVO;
import com.carbon.model.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Administrator
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-01-07 20:01:56
*/
@Service
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * 
     * @author ganbin
     * @date 2025/1/9 下午6:42 
     * @param userRegisterRequest 注册信息
     * @return long id
     */
    long userRegister(UserRegisterRequest userRegisterRequest);

    /**
     * 用户登录
     * @param userLoginRequest 登录信息
     * @param request 请求
     * @return UserLoginVO
     */
    UserLoginVO userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request);

    /**
     * 用户注销
     * @param request 请求
     */
    void userLogout(HttpServletRequest request);


    /**
     * 删除用户
     * @param id id
     * @return boolean
     */
    boolean removeUser(Long id);


    /**
     * 获取脱敏用户信息(对自己)
     * @param user 用户信息
     * @return UserLoginVO 脱敏用户信息
     */
    UserLoginVO getLoginUserVO(User user);


    /**
     * 获取脱敏用户信息(对别人)
     * @param user 用户信息
     * @return UserLoginVO 脱敏用户信息
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏用户信息(对别人)
     * @param userList 用户信息
     * @return UserVO 脱敏用户信息
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 获取当前登录用户
     * @param request 请求
     * @return User 用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取加密密码
     * @param password 密码
     * @return 加密密码
     */
    String getEncryptPassword(String password);


    /**
     * 获取默认用户名
     * @param userAccount 用户账号
     * @return 默认用户名
     */
    String getDefaultUserName(String userAccount);

    LambdaQueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    Long addUser(UserAddRequest entity);

    UserVO getUserVoById(Long id);

    User getUserById(Long id);

    Page<UserVO> getList(UserQueryRequest entity);
}
