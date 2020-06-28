package person.inview.mymanageserver.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import person.inview.mymanageserver.mapper.UserMapper;
import person.inview.mymanageserver.pojo.UserInfo;
import web.WebResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserMapper userMapper;

    @PostMapping("/login")
    WebResult login(@RequestParam("username") String username,
                    @RequestParam("password") String password,
                    HttpSession session) {
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            /** 参数有为空   */
            return WebResult.getResult(WebResult.NULL, null, null);
        }
        var user = userMapper.selectOne(new QueryWrapper<UserInfo>().eq("username", "admin"));
        if (user == null) {
            /** 用户名不存在 */
            return WebResult.getResult(WebResult.USER_NULL, null, null);
        }
        if (user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return WebResult.getResult(WebResult.OK, null, null);
        } else {
            return WebResult.getResult(WebResult.PASSWORD_ERROR, null, null);
        }
    }

    @PostMapping("test")
    WebResult test(HttpServletRequest request) {
        var result = new HashMap<String, UserInfo>();
        var t = userMapper.selectList(null);
        for (UserInfo userInfo : t) {
            result.put(userInfo.getUsername(), userInfo);
        }
        return WebResult.getResult(WebResult.OK, result, null);
    }

    @GetMapping("/toLogin")
    WebResult toLogin() {
        return WebResult.shouldLogin();
    }

    @PostMapping("/user/updateUser")
    WebResult updateUser(UserInfo userInfo, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user");

        var u2 = userMapper.selectById(userInfo.getId());
        if (u2 != null) {
            if (userMapper.updateById(userInfo) > 0)
                return WebResult.success();
            else
                return WebResult.error(null);
        } else
            return WebResult.getResult(WebResult.USER_NULL, "没有此用户ID", "");
    }
}
