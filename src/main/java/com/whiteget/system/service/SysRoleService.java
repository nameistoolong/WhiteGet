package com.whiteget.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whiteget.system.domain.SysRoleDO;

import java.util.Set;

/**
 * 系统权限service
 *
 * @author fjc
 */
public interface SysRoleService extends IService<SysRoleDO> {
    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限标识集合
     */
    Set<String> selectRoleByUserId(Long userId);
}
