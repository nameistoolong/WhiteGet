package com.whiteget.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whiteget.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户
 *
 * @author fjc
 */
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDO extends BaseEntity {

    /**
     * 用户名
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 加密盐
     */
    private String salt;
    /**
     * 性别（1.男 2.女）
     */
    private Short gender;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户状态（1.正常 2.停用）
     */
    private Short status;
    /**
     * 删除标识（0.删除 1.正常）
     */
    private Short delFlag;
}
