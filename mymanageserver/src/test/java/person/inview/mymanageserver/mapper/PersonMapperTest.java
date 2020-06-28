package person.inview.mymanageserver.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.PersonDetails;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class PersonMapperTest {
    @Resource
    private PersonMapper personMapper;

    @Test
    void add(){
        PersonDetails pd = new PersonDetails("jjj", "tel", "code", "other", "公司");
        assertTrue(personMapper.insert(pd)>0);
    }

    @Test
    void showLst(){
        personMapper.selectList(null).forEach(System.out::println);
    }
}