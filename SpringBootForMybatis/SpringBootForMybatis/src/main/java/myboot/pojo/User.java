package myboot.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode
public class User {
    private String userCode;

    private String userName;

    private String password;

    private byte permissionId;

    private Date createDate;
}

