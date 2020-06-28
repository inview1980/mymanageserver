package person.inview.mymanageserver.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.RentalRecord;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class RentalRecordMapperTest {
    @Resource
    private RentalRecordMapper recordMapper;

    @Test
    void add() {
        LocalDate ld = LocalDate.now();
        RentalRecord rr = new RentalRecord(ld, 4, ld, 2, 2, false, "222-4", ld, 2, 5, 33, 5, ld, 2, "");
        rr.setContainRealty(false);
        rr.setContractMonth(4);
        rr.setContractSigningDate(LocalDate.now());
        rr.setDeposit(55.3);
        rr.setMonthlyRent(54);
        rr.setRoomNumber("422-3");
        assertTrue(recordMapper.insert(rr) > 0);
    }

    @Test
    void showLst(){
        recordMapper.selectList(null).forEach(System.out::println);
    }
}