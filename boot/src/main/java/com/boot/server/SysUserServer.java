package com.boot.server;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.mapper.SysUserMapper;
import com.boot.pojo.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServer extends ServiceImpl<SysUserMapper, SysUser> {

}
