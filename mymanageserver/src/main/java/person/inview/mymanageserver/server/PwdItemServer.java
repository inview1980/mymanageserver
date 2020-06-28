package person.inview.mymanageserver.server;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import person.inview.mymanageserver.mapper.PwdItemMapper;
import pojo.UserItem;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PwdItemServer {
    @Resource
    private PwdItemMapper itemMapper;

    public int getItemCount(int userId, int type) {
        return itemMapper.selectCount(new LambdaQueryWrapper<UserItem>().eq(UserItem::getTypeNameId, type)
                .eq(UserItem::getUserId, userId)
        );
    }

    public List<UserItem> getItemList(int userId, int type) {
        return itemMapper.selectList(new LambdaQueryWrapper<UserItem>().eq(UserItem::getTypeNameId, type)
                .eq(UserItem::getUserId, userId)
        );
    }

    public int insert(UserItem userItem) {
        return itemMapper.insert(userItem);
    }

    public int update(UserItem userItem) {
        var item = itemMapper.selectById(userItem.getId());
        if (item == null) return -1;
        return itemMapper.updateById(userItem);
    }

    public int deleteItem(int itemId, int userId) {
        var item = itemMapper.selectById(itemId);
        if (item == null) return -1;
        if (item.getUserId() != userId) return 0;
        return itemMapper.deleteById(itemId);
    }

    public int updateItems(List<UserItem> userItems, int id) {
        int count=0;
        for (UserItem item : userItems) {
            if (item == null || StrUtil.isBlank(item.getItemName()) || item.getTypeNameId() == 0 || item.getId() == 0 || item.getId() != id)
                continue;
            //无此记录不更新
            if(itemMapper.selectById(item.getId())==null)
                continue;
            count+=itemMapper.updateById(item);
        }
        return count;
    }

    public int deleteAllByUserID(int id) {
        return itemMapper.delete(new LambdaQueryWrapper<UserItem>().eq(UserItem::getUserId, id));
    }
}
