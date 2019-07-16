package com.whiteget.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whiteget.system.dao.SysMenuMapper;
import com.whiteget.system.domain.SysMenuDO;
import com.whiteget.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统菜单实现类
 *
 * @author fjc
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuDO> implements SysMenuService {

    @Resource
    private SysMenuMapper menuMapper;

    /**
     * 根据用户ID查询菜单
     *
     * @param userId 用户ID
     * @return 系统菜单权限标识
     */
    @Override
    public Set<String> selectSysMenuByUserId(Long userId) {
        List<String> permList = menuMapper.selectMenuByUserId(
                Wrappers.<SysMenuDO>query()
                        .eq("sur.sys_user_id", userId));
        Set<String> menuSet = new HashSet<>();
        for(String perm : permList){
            menuSet.addAll(Arrays.asList(perm.split(",")));
        }
        return menuSet;
    }
}
