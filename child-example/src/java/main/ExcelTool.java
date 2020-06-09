package src.java.main;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import main.model.Head2;
import main.model.Head3;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.ArrayList;
import java.util.List;

public class ExcelTool {
    private String filePath = "f:/幼儿园数学题.xlsx";

    public void run(){
        var em=new Example(1000);
        var ee=EasyExcel.write(filePath).build();
        var sheet2=EasyExcel.writerSheet("普加减").head(Head2.class).registerWriteHandler(getStyle()).build();
        ee.write(listTo2List(em.getChildExampleDouble()), sheet2);

        var sheet3=EasyExcel.writerSheet("连加减").head(Head3.class).registerWriteHandler(getStyle()).build();
        ee.write(listTo2List(em.getChildExampleThree()),sheet3);
        ee.finish();
    }

    private WriteHandler getStyle() {
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 字体策略
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints((short) 14);
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //设置 垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//        //设置 水平居中
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        // 这个策略是 头是头的样式 内容是内容的样式 其他的策略可以自己实现
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy( contentWriteCellStyle,contentWriteCellStyle);
        return horizontalCellStyleStrategy;
    }

    public void ToExcel(List<List<String>> lst, String sheetName) {
        EasyExcel.write(filePath).sheet(sheetName).doWrite(listTo2List(lst));
//        EasyExcel.write(filePath,ExampleDataDouble.class    ).sheet("sheet1").doWrite(lst);
    }

    private List<List<String>> listTo2List(List<List<String>> lst) {
        var result = new ArrayList<List<String>>();
        int count=lst.size() / 2 - 1;
        for (int i = 0; i < count; i++) {
            var tmp = new ArrayList<String>();
            for (int j = 0; j < lst.get(0).size(); j++) {
                tmp.add(lst.get(2 * i).get(j));
            }
            tmp.add("");
            for (int j = 0; j < lst.get(0).size(); j++) {
                tmp.add(lst.get(2 * i + 1).get(j));
            }
            result.add(tmp);
        }
        return result;
    }
}
