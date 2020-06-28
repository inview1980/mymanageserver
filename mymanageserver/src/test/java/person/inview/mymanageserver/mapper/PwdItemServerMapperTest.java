package person.inview.mymanageserver.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.UserItem;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class PwdItemServerMapperTest {
    @Resource
    private PwdItemMapper itemMapper;

    @Test
    void add() {
        UserItem ui = new UserItem("222", "djd", "ndfj", "sfjk", "remark", "salt", 3, 4);
        assertTrue(itemMapper.insert(ui) > 0);
    }

    @Test
    void showLst() {
        itemMapper.selectList(null).forEach(System.out::println);
    }
}