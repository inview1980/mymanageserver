package person.inview.mymanageserver.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import person.inview.mymanageserver.pojo.UserInfo;
import person.inview.mymanageserver.server.IconServer;
import person.inview.mymanageserver.server.PwdItemServer;
import pojo.IconDetails;
import pojo.UserItem;
import web.WebResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/pwd")
public class PwdItemController {
    @Resource
    private IconServer iconServer;
    @Resource
    private PwdItemServer itemServer;

    /**
     * 获取当前用户、所有密码项目的图标、条目的总数
     *
     * @return data为Map<IconDetails, int>
     */
    @GetMapping("/itemMenu")
    WebResult getItemMenu(HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        var icons = iconServer.getIcons(1);
        var map = new HashMap<IconDetails, Integer>();
        for (IconDetails icon : icons) {
            map.put(icon, itemServer.getItemCount(userInfo.getId(), icon.getId()));
        }
        return WebResult.getResult(WebResult.OK, map, null);
    }

    /**
     * 获取指定用户、指定密码项目所有的条目明细
     *
     * @param type 密码项目id
     * @return data为List<UserItem>
     */
    @GetMapping("/items")
    WebResult getItems(int type, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        return WebResult.getResult(WebResult.OK, itemServer.getItemList(userInfo.getId(), type), "");
    }

    @PostMapping("/addItem")
    WebResult addItem(UserItem userItem, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        if (userItem == null || StrUtil.isBlank(userItem.getItemName()) || userItem.getTypeNameId() == 0)
            return WebResult.getResult(WebResult.NULL, "", "");

        userItem.setUserId(userInfo.getId());
        int i = itemServer.insert(userItem);
        if (i > 0) return WebResult.getResult(WebResult.OK, "", "");
        else return WebResult.getResult(WebResult.ERROR, "写数据库失败", "");
    }

    @PostMapping("/updateItem")
    WebResult updateItem(UserItem userItem, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        if (userItem == null || StrUtil.isBlank(userItem.getItemName()) || userItem.getTypeNameId() == 0 || userItem.getId() == 0)
            return WebResult.getResult(WebResult.NULL, "", "");

        if (userInfo.getId() != userItem.getUserId())
            return WebResult.getResult(WebResult.ERROR, "用户ID不一致", "");

        int i = itemServer.update(userItem);
        if (i > 0) return WebResult.getResult(WebResult.OK, "", "");
        else return WebResult.getResult(WebResult.ERROR, "更新数据库失败", "");
    }

    @PostMapping("/updateItems")
    WebResult updateItems(List<UserItem> userItems, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        if (userItems == null || userItems.size()==0)
            return WebResult.getResult(WebResult.NULL, "", "");

        int i = itemServer.updateItems(userItems,userInfo.getId());
        if (i > 0) return WebResult.getResult(WebResult.OK, "", "");
        else return WebResult.getResult(WebResult.ERROR, "更新数据库失败", "");
    }

    @GetMapping("/deleteItem")
    WebResult deleteItem(int itemId, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        if ( itemId == 0 )
            return WebResult.getResult(WebResult.NULL, "", "");


        int i = itemServer.deleteItem(itemId,userInfo.getId());
        if (i > 0)
            return WebResult.getResult(WebResult.OK, "", "");
        else if(i==0)
            return WebResult.getResult(WebResult.ERROR, "用户ID不一致", "");
        else
            return WebResult.getResult(WebResult.ERROR, "更新数据库失败", "");
    }

    @GetMapping("/deleteAllByUserID")
    WebResult deleteAllByUserID(HttpSession session){
        UserInfo userInfo = (UserInfo) session.getAttribute("user");

        int i=itemServer.deleteAllByUserID(userInfo.getId());
        if (i > 0)
            return WebResult.getResult(WebResult.OK, "", "");
        else
            return WebResult.getResult(WebResult.ERROR, "更新数据库失败", "");
    }
}
