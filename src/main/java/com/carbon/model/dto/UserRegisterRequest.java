package com.carbon.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -8159385528353316856L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

}


