package com.whiteget.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whiteget.system.dao.SysUserMapper;
import com.whiteget.system.domain.SysUserDO;
import com.whiteget.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 系统用户实现类
 *
 * @author fjc
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDO> implements SysUserService {
}
