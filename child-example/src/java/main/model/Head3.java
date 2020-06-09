package main.model;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@ContentRowHeight(30)
@HeadRowHeight(30)
@Data
public class Head3 {
    @ColumnWidth(9)
    private String s1;
    @ColumnWidth(3)
    private String s2;
    @ColumnWidth(9)
    private String s3;
    @ColumnWidth(3)
    private String s4;
    @ColumnWidth(9)
    private String s5;
    @ColumnWidth(3)
    private String s6;
    @ColumnWidth(9)
    private String s7;
    @ColumnWidth(9)
    private String s8;
    @ColumnWidth(9)
    private String s9;
    @ColumnWidth(3)
    private String s10;
    @ColumnWidth(9)
    private String s11;
    @ColumnWidth(3)
    private String s12;
    @ColumnWidth(9)
    private String s13;
    @ColumnWidth(3)
    private String s14;
    @ColumnWidth(9)
    private String s15;
}
