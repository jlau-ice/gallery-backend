CREATE TABLE `user`
(
    `id`            bigint(20)                              NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_account`  varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
    `user_password` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
    `user_name`     varchar(256) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '用户昵称',
    `user_avatar`   varchar(1024) COLLATE utf8mb4_unicode_ci         DEFAULT NULL COMMENT '用户头像',
    `user_profile`  varchar(512) COLLATE utf8mb4_unicode_ci          DEFAULT NULL COMMENT '用户简介',
    `user_role`     varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT '用户角色：user/admin',
    `edit_time`     datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
    `create_time`   datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_delete`     tinyint(4)                              NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_account` (`user_account`),
    KEY `idx_user_name` (`user_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='用户';