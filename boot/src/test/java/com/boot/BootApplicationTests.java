package com.boot;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.boot.mapper.SysUserMapper;
import com.boot.mapper.UserMapper;
import com.boot.pojo.SysUser;
import com.boot.pojo.User;
import com.boot.server.SysUserServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BootApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysUserMapper sud;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
	}


    @Test
    void contextLoads() {
        List<SysUser> lst = sud.getAll();
        lst.forEach(System.out::println);
    }

    @Autowired
    SysUserServer sysUserServer;

    @Test
    void userDao() {
        var wrapper = new LambdaQueryWrapper<SysUser>();
        var t = sysUserServer.list(wrapper.eq(SysUser::getId, 1));
        t.forEach(System.out::println);
    }
}
