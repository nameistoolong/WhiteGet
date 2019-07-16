package com.whiteget.framework.shiro.util;

import com.whiteget.system.domain.SysUserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

/**
 * shiro工具类
 *
 * @author fjc
 */
public class ShiroUtils {
    /**
     * 获取subject
     *
     * @return subject
     */
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    /**
     * 获取登陆用户信息
     *
     * @return 系统用户DO
     */
    public static SysUserDO getUserDO(){
        SysUserDO userDO = null;
        Subject subject = getSubject();
        Object principal = subject.getPrincipal();
        if(null != principal){
            userDO = new SysUserDO();
            BeanUtils.copyProperties(principal, userDO);
        }
        return userDO;
    }
}
