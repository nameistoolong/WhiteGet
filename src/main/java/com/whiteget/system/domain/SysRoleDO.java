package com.whiteget.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whiteget.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统权限表, 我起了，一枪秒了，有什么好说的
 *
 * @author fjc
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sys_role")
@Data
public class SysRoleDO extends BaseEntity {
    /**
     * 权限名称
     */
    private String roleName;
    /**
     * 权限标识
     */
    private String roleSign;
    /**
     * 权限状态（1.启用 2.停用）
     */
    private Short status;
    /**
     * 删除标识（0.删除 1.正常）
     */
    private Short delFlag;
}
