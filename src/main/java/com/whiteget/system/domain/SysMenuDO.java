package com.whiteget.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whiteget.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统菜单
 *
 * @author fjc
 */
@TableName
@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenuDO extends BaseEntity {
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父级菜单名称
     */
    private Long parentId;
    /**
     * 访问的url
     */
    private String url;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 菜单类型（C. 目录 M. 菜单 B. 按钮）
     */
    private String type;
    /**
     * 图标
     */
    private String icon;
    /**
     * 显示顺序
     */
    private Integer sort;
    /**
     * 是否隐藏（0.隐藏 1.显示）
     */
    private Short visible;
}
