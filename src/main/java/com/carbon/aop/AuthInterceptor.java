package com.carbon.aop;

import com.carbon.annotation.AuthCheck;
import com.carbon.exception.ErrorCode;
import com.carbon.exception.ThrowUtils;
import com.carbon.model.entity.User;
import com.carbon.model.enums.UserRoleEnum;
import com.carbon.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AuthInterceptor {

    private final UserService userService;

    @Autowired
    public AuthInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        User loginUser = userService.getLoginUser(request);
        UserRoleEnum mustRoleEnum = UserRoleEnum.getEnumByValue(mustRole);
        if (mustRoleEnum == null){
            return joinPoint.proceed();
        }
        UserRoleEnum userRoleEnum = UserRoleEnum.getEnumByValue(loginUser.getUserRole());
        ThrowUtils.throwIf(UserRoleEnum.ADMIN.equals(mustRoleEnum) && !UserRoleEnum.ADMIN.equals(userRoleEnum), ErrorCode.NOT_AUTH_ERROR);
        return joinPoint.proceed();
    }
}


