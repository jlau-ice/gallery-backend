package com.carbon.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon.common.Constant;
import com.carbon.exception.ErrorCode;
import com.carbon.exception.ThrowUtils;
import com.carbon.model.dto.UserLoginRequest;
import com.carbon.model.dto.UserRegisterRequest;
import com.carbon.model.entity.User;
import com.carbon.model.enums.UserRoleEnum;
import com.carbon.model.vo.UserLoginVO;
import com.carbon.service.UserService;
import com.carbon.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @description 针对表【user(用户)】的数据库操作Service实现
 * @createDate 2025-01-07 20:01:56
 */
@Service
@Slf4j
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
        ThrowUtils.throwIf(StrUtil.hasBlank(userRegisterRequest.getUserAccount(), userRegisterRequest.getUserPassword(), userRegisterRequest.getCheckPassword()), ErrorCode.PARAMS_ERROR, "参数为空");
        ThrowUtils.throwIf((userRegisterRequest.getUserPassword().length() < 8 || userRegisterRequest.getCheckPassword().length() < 8), ErrorCode.PARAMS_ERROR, "密码长度不能小于8位");
        ThrowUtils.throwIf(!userRegisterRequest.getUserPassword().equals(userRegisterRequest.getCheckPassword()), ErrorCode.PARAMS_ERROR, "两次输入的密码不一致");
        // 2. 重复数据账号
        Long count = this.baseMapper.selectCount(Wrappers.lambdaQuery(User.class).eq(User::getUserAccount, userRegisterRequest.getUserAccount()));
        ThrowUtils.throwIf(count > 0, ErrorCode.PARAMS_ERROR, "账号重复");
        // 3. 加密
        userRegisterRequest.setUserPassword(getEncryptPassword(userRegisterRequest.getUserPassword()));
        // 4. 插入数据到数据库中
        User user = new User();
        user.setUserAccount(userRegisterRequest.getUserAccount());
        user.setUserPassword(userRegisterRequest.getUserPassword());
        user.setUserName(getDefaultUserName(userRegisterRequest.getUserAccount()));
        user.setUserRole(UserRoleEnum.USER.getValue());
        boolean saveResult = this.save(user);
        ThrowUtils.throwIf(!saveResult, ErrorCode.SYSTEM_ERROR, "注册失败,数据库错误");
        return user.getId();
    }

    @Override
    public UserLoginVO userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request) {
        // 校验
        ThrowUtils.throwIf(StrUtil.hasBlank(userLoginRequest.getUserAccount(), userLoginRequest.getUserPassword()), ErrorCode.PARAMS_ERROR, "参数为空");
        // 查询 密码加密对比
        String encryptPassword = getEncryptPassword(userLoginRequest.getUserPassword());
        User user = this.baseMapper.selectOne(
                Wrappers.lambdaQuery(User.class)
                        .eq(User::getUserAccount, userLoginRequest.getUserAccount())
                        .eq(User::getUserPassword, encryptPassword)
        );
        ThrowUtils.throwIf(user == null, ErrorCode.PARAMS_ERROR, "账号或密码错误");
        // 返回
        HttpSession session = request.getSession();
        session.setAttribute(Constant.USER_LOGIN_STATE, user);
        return this.getLoginUserVO(user);
    }

    @Override
    public User getLoginUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(Constant.USER_LOGIN_STATE);
        User user = (User) userObj;
        ThrowUtils.throwIf(user == null || user.getId() == null, ErrorCode.NO_LOGIN_ERROR);
        User currentUser =  this.getById(user.getId());
        ThrowUtils.throwIf(currentUser == null, ErrorCode.NO_LOGIN_ERROR);
        return currentUser;
    }


    @Override
    public void userLogout(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(Constant.USER_LOGIN_STATE);
        User user = (User) userObj;
        ThrowUtils.throwIf(user == null, ErrorCode.OPERATION_ERROR,"未登录");
        request.getSession().removeAttribute(Constant.USER_LOGIN_STATE);
    }

    @Override
    public UserLoginVO getLoginUserVO(User user) {
        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtil.copyProperties(user, userLoginVO);
        return userLoginVO;
    }


    @Override
    public String getEncryptPassword(String password) {
        return DigestUtils.md5DigestAsHex((Constant.SALT + password).getBytes());
    }

    @Override
    public String getDefaultUserName(String userAccount) {
        // 唯一性的名称
        return userAccount + "_" + System.currentTimeMillis();
    }


}




