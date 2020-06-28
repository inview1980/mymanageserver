package person.inview.mymanageserver.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Multimap;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import person.inview.mymanageserver.mapper.PwdItemMapper;
import person.inview.mymanageserver.pojo.UserInfo;
import pojo.UserItem;
import web.WebResult;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Random;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class PwdItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Resource
    private PwdItemMapper itemMapper;
    private MockHttpSession session;
    private int userId;

    @BeforeEach
    public void before() {
        session = new MockHttpSession();
        UserInfo user = new UserInfo();
        userId = new Random().nextInt(100) + 1;
        user.setId(userId);
        session.setAttribute("user", user);
    }

    @Test
    void getItemMenu() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pwd/itemMenu")
                .accept(MediaType.APPLICATION_JSON).session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isMap())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void getItems() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pwd/items").param("type", "1")
                .accept(MediaType.APPLICATION_JSON).session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isNotEmpty())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void addItem() throws Exception {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("itemName", "类型:10");
        map.add("typeNameId", String.valueOf(new Random().nextInt(8) + 1));
        mockMvc.perform(MockMvcRequestBuilders.post("/pwd/addItem").params(map)
                .accept(MediaType.APPLICATION_JSON).session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.state").value(WebResult.OK));
//                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateItem() throws Exception {
        var item = itemMapper.selectList(Wrappers.<UserItem>lambdaQuery().eq(UserItem::getUserId, userId)).get(0);
        if (item == null) throw new NullPointerException("在数据库中没有找到相应的数据");
        item.setItemName("更新后");
        var map = getItem2Map(item);
        mockMvc.perform(MockMvcRequestBuilders.post("/pwd/updateItem").params(map)
                .accept(MediaType.APPLICATION_JSON).session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.state").value(WebResult.OK));
        System.out.println("userID:" + userId);
    }

    @Test
    void deleteItem() throws Exception {
        var item = itemMapper.selectList(Wrappers.<UserItem>lambdaQuery().eq(UserItem::getUserId, userId)).get(0);
        if (item == null) throw new NullPointerException("在数据库中没有找到相应的数据");
        var map = new LinkedMultiValueMap<String, String>();
        map.add("itemId", item.getId() + "");
        mockMvc.perform(MockMvcRequestBuilders.get("/pwd/deleteItem").params(map)
                .accept(MediaType.APPLICATION_JSON).session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.state").value(WebResult.OK));
        System.out.println("userID:" + userId+"itemId:"+item.getId());
    }

    private MultiValueMap<String, String> getItem2Map(UserItem item) throws IllegalAccessException {
        var map = new LinkedMultiValueMap<String, String>();
        Field[] fields = item.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.add(field.getName(), String.valueOf(field.get(item)));
        }
        return map;
    }
}