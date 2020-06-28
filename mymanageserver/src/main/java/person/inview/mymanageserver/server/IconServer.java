package person.inview.mymanageserver.server;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import person.inview.mymanageserver.mapper.IconMapper;
import pojo.IconDetails;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IconServer {
    @Resource private IconMapper iconMapper;

    public List<IconDetails> getIcons(int type){
        return iconMapper.selectList(new LambdaQueryWrapper<IconDetails>().eq(IconDetails::getType, type));
    }
}
