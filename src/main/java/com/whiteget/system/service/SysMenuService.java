package com.whiteget.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whiteget.system.domain.SysMenuDO;

import java.util.Set;

/**
 * 系统菜单service
 *
 * @author fjc
 */
public interface SysMenuService extends IService<SysMenuDO> {
    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 系统菜单权限标识
     */
    Set<String> selectSysMenuByUserId(Long userId);
}
