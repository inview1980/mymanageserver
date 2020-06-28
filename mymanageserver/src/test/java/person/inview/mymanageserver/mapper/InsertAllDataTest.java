package person.inview.mymanageserver.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import person.inview.mymanageserver.pojo.UserInfo;
import pojo.PersonDetails;
import pojo.RentalRecord;
import pojo.RoomDetails;
import pojo.UserItem;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
 class InsertAllDataTest {
    @Resource
    private PersonMapper personMapper;
    @Resource
    private PwdItemMapper itemMapper;
    @Resource
    private RentalRecordMapper recordMapper;
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private UserMapper userMapper;
    private Random random = new Random();

    @Test
    void insertData() {
        cleanDB();
        int recordMax = 2000;
        int roomMax = 100;
        int manMax = 200;
        int typeMax = 8;
        int userMax=20;

        insertPersons(manMax);
        insertPwdItem(1000, typeMax,userMax);
        insertRecord(recordMax, roomMax, manMax);
        insertRoom(roomMax, recordMax);
        insertUser(userMax);
    }

    private void cleanDB() {
        userMapper.delete(null);
        roomMapper.delete(null);
        recordMapper.delete(null);
        itemMapper.delete(null);
        personMapper.delete(null);
    }

    private void insertUser(int i) {
        UserInfo userInfo;
        for (int i1 = 1; i1 <= i; i1++) {
            userInfo = new UserInfo();
            userInfo.setUsername(String.valueOf(i1));
            userInfo.setNickname("昵称:" + i1);
            userInfo.setPassword(String.valueOf(i1));
            userInfo.setPhone("TEL:"+i1);

            userMapper.insert(userInfo);
        }
    }

    private void insertRoom(int i, int recordMax) {
        RoomDetails room;
        for (int i1 = 0; i1 < i; i1++) {
            room = new RoomDetails();
            room.setRoomNumber("房号：" + i1);
            room.setCommunityName("小区：" + random.nextInt(10));
            room.setRoomArea(random.nextDouble() * 200);
            room.setPropertyPrice(random.nextDouble() * 10);
            room.setDelete(random.nextBoolean());
            room.setRecordId(random.nextInt(recordMax) + 1);
            room.setElectricMeter("电表：" + i1);
            room.setWaterMeter("水表:" + i1);
            roomMapper.insert(room);
        }
    }

     void insertRecord(int i, int roomMax, int manMax) {
        RentalRecord rr;
        for (int i1 = 0; i1 < i; i1++) {
            rr = new RentalRecord();
            rr.setRoomNumber("房号：" + random.nextInt(roomMax));
            rr.setMonthlyRent(random.nextDouble() * 5000);
            rr.setDeposit(rr.getMonthlyRent());
            rr.setContractSigningDate(getDate());
            rr.setContractMonth(random.nextInt(12) + 1);
            rr.setManID(random.nextInt(manMax));
            rr.setPaymentDate(getDate());
            rr.setPayMonth(random.nextInt(12) + 1);
            rr.setPropertyCosts(random.nextDouble() * 50);
            rr.setRealtyStartDate(getDate());
            rr.setStartDate(getDate());
            rr.setContainRealty(random.nextBoolean());
            rr.setTotalMoney(random.nextDouble() * 15000);
            recordMapper.insert(rr);
        }
    }

    private void insertPwdItem(int i, int typeMax,int userMax) {
        UserItem ui;
        for (int i1 = 0; i1 < i; i1++) {
            ui = new UserItem();
            ui.setUserName("userName:" + i1);
            ui.setItemName("类型:"+i1);
            ui.setPassword("password:" + i1);
            ui.setTypeNameId(random.nextInt(typeMax) + 1);
            ui.setSalt("salt:" + i1);
            ui.setUserId(random.nextInt(userMax )+1);
            itemMapper.insert(ui);
        }
    }

    private void insertPersons(int i) {
        PersonDetails pd;
        for (int i1 = 0; i1 < i; i1++) {
            pd = new PersonDetails();
            pd.setName("name:" + i1);
            pd.setCord("code:" + i1);
            pd.setCompany("公司:" + i1);
            pd.setTel("TEL:" + i1);
            personMapper.insert(pd);
        }
    }

    LocalDate getDate() {
        return LocalDate.ofYearDay(random.nextInt(500) + 1750, random.nextInt(365)+1);
    }
}
