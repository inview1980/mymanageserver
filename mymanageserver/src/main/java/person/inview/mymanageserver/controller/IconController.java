package person.inview.mymanageserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import person.inview.mymanageserver.mapper.IconMapper;
import person.inview.mymanageserver.server.IconServer;
import pojo.IconDetails;
import web.WebResult;

import javax.annotation.Resource;

@RestController
public class IconController {
    @Resource
    private IconServer iconServer;

    @GetMapping("/icon")
    public WebResult getIcon(int type) {
        WebResult tmp = WebResult.getResult(WebResult.OK, iconServer.getIcons(type), null);
        return tmp;
    }
}
