package com.carbon.model.enums;

import cn.hutool.core.util.ObjUtil;

public enum UserRoleEnum {

    USER("普通用户", "user"),
    ADMIN("管理员", "admin");

    public final String text;
    public final String value;

    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public static UserRoleEnum getEnumByValue(String value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        for (UserRoleEnum userRoleEnum : UserRoleEnum.values()) {
            if (userRoleEnum.value.equals(value)) {
                return userRoleEnum;
            }
        }
        return null;
    }
}
