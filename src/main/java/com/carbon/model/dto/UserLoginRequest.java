package com.carbon.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -1904514471844458278L;

    private String userAccount;

    private String userPassword;

}


