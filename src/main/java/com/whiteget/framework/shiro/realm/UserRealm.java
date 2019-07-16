package com.whiteget.framework.shiro.realm;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.whiteget.system.domain.SysUserDO;
import com.whiteget.system.service.SysMenuService;
import com.whiteget.system.service.SysRoleService;
import com.whiteget.system.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

import java.util.Set;

import static com.whiteget.framework.shiro.util.ShiroUtils.getUserDO;

/**
 * 自定义realm
 *
 * @author fjc
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private SysRoleService roleService;

    @Resource
    private SysMenuService menuService;

    @Resource
    private SysUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserDO userDO = getUserDO();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(null != userDO){
            Set<String> roleKeyList = roleService.selectRoleByUserId(userDO.getId());
            Set<String> permList = menuService.selectSysMenuByUserId(userDO.getId());
            info.setRoles(roleKeyList);
            info.setStringPermissions(permList);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String passwd = new String((char[]) token.getCredentials());
        SysUserDO sysUser = userService.getOne(Wrappers.<SysUserDO>query().eq("username", username));
        if(null == sysUser || !passwd.equals(sysUser.getPassword())){
            throw new IncorrectCredentialsException("用户名/密码输入有误，请重新输入！");
        }
        if(sysUser.getStatus() == 2){
            throw new LockedAccountException("账号已被停用，请联系管理！");
        }
        return new SimpleAuthenticationInfo(username, passwd, getName());
    }
}
