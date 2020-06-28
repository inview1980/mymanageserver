package person.inview.mymanageserver.interceptor;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import person.inview.mymanageserver.pojo.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Slf4j
public final class MyInterceptor implements HandlerInterceptor {
    /**
     * 处理器前方法
     *
     * @return 返回true，不会拦截后续的处理
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var user = (UserInfo) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/toLogin");
            return false;
        }
//        String userIDStr = request.getParameter("userID");
//        int userID = 0;
//        if (StrUtil.isBlank(userIDStr))
//            return false;
//        try {
//            userID = Integer.parseInt(userIDStr);
//            return userID == user.getId();
//        } catch (NumberFormatException e) {
//            log.error("参数userID出错");
//        }
//        log.info("code:{}", user.toString());
        return true;
    }

}
