package person.inview.mymanageserver.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import person.inview.mymanageserver.pojo.UserInfo;
import pojo.RoomDetails;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class RoomMapperTest {
    @Resource
    private RoomMapper roomMapper;

    @Test
    void add() {
        RoomDetails rd = new RoomDetails();
        rd.setCommunityName("小区1");
        rd.setRoomNumber("门牌号：1-1");
        rd.setWaterMeter("1-2-3");
        rd.setRoomArea(44);
        rd.setRecordId(1);
        rd.setElectricMeter("2-3-4");
        rd.setDelete(true);
        rd.setPropertyPrice(4.53);
        var r2 = roomMapper.selectOne(new QueryWrapper<RoomDetails>().eq("roomNumber", rd.getRoomNumber()));
        if (r2 == null)
            assertTrue(roomMapper.insert(rd) > 0);
        else
            assertTrue(roomMapper.update(rd,new QueryWrapper<RoomDetails>().eq("roomNumber", rd.getRoomNumber()))>0);
    }

    @Test
    void showList() {
        roomMapper.selectList(null).forEach(System.out::println);
    }
}