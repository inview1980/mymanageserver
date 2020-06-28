INSERT INTO sys_user (username, nickname, password, salt, phone, gender, head, remark, state, role_id, deleted,
                      create_time, update_time)
VALUES ('admin', '管理员', '123', '666', '', 1,
        'http://localhost:8888//resource/201910281559227.jpg', 'Administrator Account', 1, 1, 0, '2019-08-26 00:52:01',
        '2019-10-27 23:32:29');
INSERT INTO sys_user (username, nickname, password, salt, phone, gender, head, remark, state, role_id, deleted,
                      create_time, update_time)
VALUES ('test', '测试人员', '123',
        '087c2e9857f35f1e243367f3b89b81c1', '', 1, null, 'Tester Account', 1, 2, 0, '2019-10-05 14:04:27', null);


INSERT IGNORE INTO room_details (communityName, roomNumber, roomArea, electricMeter, waterMeter, propertyPrice, isDelete,
                          recordId)
values ('aaa1', '1-1-1', 22.33, '', '', 33.4, 0, null);
INSERT IGNORE INTO Room_Details (communityName, roomNumber, roomArea, electricMeter, waterMeter, propertyPrice, isDelete,
                          recordId)
values ('aaa2', '2-2-2', 31.33, '3', '', 4.4, 1, null);

INSERT INTO `rental_record`
VALUES (1,'2020-6-26', 4, '2020-6-26', 0, 0, 0, '422-3', '2020-6-26', 2, 5, 55, 54, '2020-6-26', 4, '')
ON DUPLICATE KEY UPDATE id=id+1;

insert into person_details(name,tel,cord,other,company )
values ('jjj', 'tel', 'code', 'other', '公司')