package com.whiteget.system.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whiteget.system.domain.SysMenuDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统菜单mapper
 *
 * @author fjc
 */
public interface SysMenuMapper extends BaseMapper<SysMenuDO> {
    /**
     * 根据用户ID 查询系统菜单
     *
     * @param wrapper mybatisPlus拼接的查询条件
     * @return 菜单权限标识集合
     */
    List<String> selectMenuByUserId(@Param("ew") Wrapper<SysMenuDO> wrapper);
}
