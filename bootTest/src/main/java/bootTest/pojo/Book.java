package bootTest.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Alias("book")
public class Book  {
    private String bookid;

    private String bookname;

    private Short booktypeid;

    private String publishment;

    private Date publishdate;

    private String author;

    private BigDecimal price;

    private String usercode;

    private Date borrowdate;
}