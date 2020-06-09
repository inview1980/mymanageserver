package src.java.main.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExampleDataDouble {
    private int numA;
    private String operation;
    private int numB;
    private int result;


    @Override
    public String toString() {
        return "ExampleDataDouble{" + numA + operation + numB + "=" + result + "}";
    }
}
