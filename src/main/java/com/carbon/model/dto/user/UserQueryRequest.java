package com.carbon.model.dto.user;

import com.carbon.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = -2587066511338605314L;

    /** 主键 */
    private Long id;

    /** 账号 */
    private String userAccount;

    /** 用户昵称 */
    private String userName;

    /** 用户简介 */
    private String userProfile;

    /** 用户角色：user/admin */
    private String userRole;
}


