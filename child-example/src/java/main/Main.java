package src.java.main;

public class Main {
    public static void main(String[] args) {
//        var ex = new Example(1000);
////        System.out.println(ex.getChildExampleDouble());
        ExcelTool excel = new ExcelTool();
////        excel.ToExcel(ex.getChildExampleDouble(),"普加减");
//        excel.ToExcel(ex.getChildExampleThree(), "连加连减");
        excel.run();
    }
}
