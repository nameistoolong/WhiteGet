package com.whiteget.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whiteget.system.dao.SysRoleMapper;
import com.whiteget.system.domain.SysRoleDO;
import com.whiteget.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 系统权限实现类
 *
 * @author fjc
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleDO> implements SysRoleService {

    @Resource
    private SysRoleMapper roleMapper;

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限标识集合
     */
    @Override
    public Set<String> selectRoleByUserId(Long userId) {
        List<String> roleKeyList = roleMapper.selectRoleByUserId(
                Wrappers.<SysRoleDO>query()
                        .eq("su.id", userId));
        if(!roleKeyList.isEmpty()){
            return new HashSet<>(roleKeyList);
        }
        return new HashSet<>();
    }
}
