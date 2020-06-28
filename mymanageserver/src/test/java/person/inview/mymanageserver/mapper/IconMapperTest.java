package person.inview.mymanageserver.mapper;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import person.inview.mymanageserver.mapper.IconMapper;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.IconDetails;
import pojo.UserItem;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
class IconMapperTest {
    @Resource
    private IconMapper iconMapper;

//    @Test
    void add() {
        for (String ss : data) {
            String[] tmp=ss.split("-");
            IconDetails ui=new IconDetails();
            ui.setId(Integer.parseInt(tmp[0]));
            ui.setIcon(tmp[1]);
            ui.setName(tmp[2]);
            ui.setColor(tmp[3]);
            ui.setType(Integer.parseInt(tmp[4]));
            iconMapper.insert(ui);
        }
    }

    @Test
    void showLst() {
        iconMapper.selectList(null).forEach(System.out::println);
    }

    private static String[] data = {"1-&#xe75e;-APP-#3396d8-1",
            "2-&#xe607;-工作-#3396d8-1",
            "3-&#xe601;-游戏-#3396d8-1",
            "4-&#xe608;-生活-#3396d8-1",
            "5-&#xe63e;-银行-#e64a19-1",
            "6-&#xe64e;-学习-#3396d8-1",
            "7-&#xe60b;-邮箱-#ffff8d-1",
            "8-&#xe767;-其他-#9e9e9e-1",
            "100-&#xe66f;-查看详情-#3396d8-2",
            "101-&#xe666;-续租-#3396d9-2",
            "102-&#xe61b;-退租-#e64a19-2",
            "103-&#xe676;-调整租金-#3396d8-2",
            "104-&#xe667;-调整押金-#3396d8-2",
            "105-&#xe650;-查看出租记录-#3396d8-2",
            "106-&#xe60e;-支付物业费-#3396d8-2",
            "107-&#xe616;-续签合同-#3396d8-2",
            "108-&#xe611;-租户资料-#3396d8-2",
            "109-&#xe63d;-删除房源-#3396d8-2",
            "200-&#xe66f;-查看详情-#3396d8-3",
            "201-&#xe63d;-出租-#3396d8-3",
            "202-&#xe676;-撤销退租-#3396d8-3",
            "203-&#xe650;-查看出租记录-#3396d8-3",
            "204-&#xe63d;-删除房源-#3396d8-3",
            "300-&#xe61c;-恢复房源-#3396d8-4",
            "301-&#xe600;-彻底删除房源-#bf360c-4"};
}