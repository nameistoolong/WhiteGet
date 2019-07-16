package com.whiteget.system.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whiteget.system.domain.SysRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统权限mapper
 *
 * @author fjc
 */
public interface SysRoleMapper extends BaseMapper<SysRoleDO> {
    /**
     * 通过系统用户ID 查询系统权限
     *
     * @param wrapper 拼接的查询条件
     * @return 权限标识集合
     */
    List<String> selectRoleByUserId(@Param("ew") Wrapper<SysRoleDO> wrapper);
}
