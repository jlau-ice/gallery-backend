/*
 Navicat Premium Dump SQL

 Source Server         : 192.168.172.94
 Source Server Type    : MySQL
 Source Server Version : 50744 (5.7.44)
 Source Host           : 192.168.172.94:3306
 Source Schema         : galley

 Target Server Type    : MySQL
 Target Server Version : 50744 (5.7.44)
 File Encoding         : 65001

 Date: 17/05/2025 20:15:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_account` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `user_password` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `user_name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_avatar` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '用户头像',
  `user_profile` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户简介',
  `user_role` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT '用户角色：user/admin',
  `edit_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '编辑时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_account`(`user_account`) USING BTREE,
  INDEX `idx_user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1878333311055671299 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1876946005442723842, '大萨达撒撒旦', '5a7848b1bab5d33d9f56565030fb2d0a', '大萨达撒旦4646', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-08 18:56:14', '2025-01-08 18:56:14', '2025-01-12 16:02:52', 0);
INSERT INTO `user` VALUES (1877303612904837122, 'admin', 'ad296088dc34ffcc67a43bce78f6fa5b', 'admin_1736419034585', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'admin', '2025-01-09 18:37:14', '2025-01-09 18:37:14', '2025-01-12 16:02:40', 0);
INSERT INTO `user` VALUES (1877304428239892482, 'user', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user_1736419228977', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-09 18:40:28', '2025-01-09 18:40:28', '2025-01-12 16:02:52', 0);
INSERT INTO `user` VALUES (1878289018924310529, 'user1', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user1_1736653973690', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:52:53', '2025-01-12 11:52:53', '2025-03-16 13:39:11', 1);
INSERT INTO `user` VALUES (1878289031784046593, 'user2', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user2_1736653976758', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:52:56', '2025-01-12 11:52:56', '2025-03-16 13:39:11', 1);
INSERT INTO `user` VALUES (1878289047223279617, 'user3', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user3_1736653980452', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:00', '2025-01-12 11:53:00', '2025-03-16 13:39:11', 1);
INSERT INTO `user` VALUES (1878289059688751105, 'user4', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user4_1736653983413', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:03', '2025-01-12 11:53:03', '2025-03-16 13:39:10', 1);
INSERT INTO `user` VALUES (1878289075371253761, 'user5', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user5_1736653987157', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:07', '2025-01-12 11:53:07', '2025-03-16 13:39:09', 1);
INSERT INTO `user` VALUES (1878289089489281026, 'user6', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user6_1736653990523', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:10', '2025-01-12 11:53:10', '2025-01-12 16:02:52', 0);
INSERT INTO `user` VALUES (1878289121764450306, 'user7', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user7_1736653998221', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:18', '2025-01-12 11:53:18', '2025-01-12 16:02:52', 0);
INSERT INTO `user` VALUES (1878289133093265409, 'user8', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user8_1736654000924', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:20', '2025-01-12 11:53:20', '2025-03-16 13:39:12', 1);
INSERT INTO `user` VALUES (1878289145990750210, 'user9', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user9_1736654003989', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:23', '2025-01-12 11:53:23', '2025-03-16 13:39:12', 1);
INSERT INTO `user` VALUES (1878289158456221698, 'user10', 'ad296088dc34ffcc67a43bce78f6fa5b', 'user10_1736654006965', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 11:53:26', '2025-01-12 11:53:26', '2025-01-12 16:02:52', 0);
INSERT INTO `user` VALUES (1878332090743795714, 'superSd', '9a14ad8091037d19a46b0578569c413e', 'superSd_1736664242815', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 14:44:02', '2025-01-12 14:44:02', '2025-03-16 13:49:33', 1);
INSERT INTO `user` VALUES (1878333311055671298, 'asdasdasd', 'bea8e09154e8fbdf26947662b48e032e', 'asdasdasd_1736664533755', 'https://pic.code-nav.cn/user_avatar/1707560031286849537/thumbnail/v99RIWka-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20220531122433.jpg', NULL, 'user', '2025-01-12 14:48:53', '2025-01-12 14:48:53', '2025-03-16 13:45:09', 1);

SET FOREIGN_KEY_CHECKS = 1;
