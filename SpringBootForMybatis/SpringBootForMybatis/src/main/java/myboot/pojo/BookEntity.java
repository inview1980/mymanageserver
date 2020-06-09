package myboot.pojo;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.sql.Date;
@Mapper
public class BookEntity {
    private String bookid;
    private String bookName;
    private short booktypeid;
    private String publishment;
    private Date publishDate;
    private String author;
    private BigDecimal price;
    private String userCode;
    private Date borrowDate;
}
