package person.inview.mymanageserver.server;

import org.springframework.stereotype.Service;
import person.inview.mymanageserver.mapper.RoomMapper;
import pojo.RoomDetails;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DBServer {
    @Resource private RoomMapper roomMapper;

    public List<RoomDetails> getRoomDetailsList(){
        return roomMapper.selectList(null);
    }
}
