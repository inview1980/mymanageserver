package src.java.main;

import javafx.util.Pair;
import main.model.ExampleDataThree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Example {
    private int ROW;
    private int MaxNo;
    private int MinNo;
    private Random random = new Random();
    private String blank = "（       ）";

    public Example() {
        this(30, 20, 0);
    }

    public Example(int ROW) {
        this(ROW, 20, 0);
    }

    public Example(int ROW, int maxNo, int minNo) {
        this.ROW = ROW;
        MaxNo = maxNo;
        MinNo = minNo;
    }

    public List<List<String>> getChildExampleDouble() {
        var result = new ArrayList<List<String>>((int) (ROW * 1.5));
        for (int i = 0; i < ROW; i++) {
            var lst = aOrB();
            int tmp = lst.getKey();
            lst.getValue().add("=");
            lst.getValue().add(String.valueOf(tmp));
            result.add(addBlank(lst.getValue()));
        }
        return result;
    }

    private List<String> addBlank(List<String> value) {
        int rand = random.nextInt(value.size() / 2 + 1);
        value.set(2 * rand, blank);
        return value;
    }


    private Pair<Integer, List<String>> aOrB() {
        var tmpLst = new ArrayList<String>();
        int n1 = random.nextInt(MaxNo) + 1;
        int tmp1 = 0;
        boolean isBreak = true;
        tmpLst.add(String.valueOf(n1));
        do {
            int n2 = random.nextInt(MaxNo) + 1;
            if ((n1 + n2) <= MaxNo || (n1 - n2) > 0) {
                isBreak = false;
                if ((n1 + n2) <= MaxNo) {
                    tmpLst.add("+");
                    tmp1 = n1 + n2;
                } else {
                    tmpLst.add("-");
                    tmp1 = n1 - n2;
                }
                tmpLst.add(String.valueOf(n2));
//                tmpLst.add(String.valueOf(tmp1) );
            }
        } while (isBreak);
        return new Pair<>(tmp1, tmpLst);
    }

    public List<List<String>> getChildExampleThree() {
        var result = new ArrayList<List<String>>((int) (ROW * 1.5));
        for (int i = 0; i < ROW; i++) {
            result.add(addBlank(threeEx()));
        }
        return result;
    }

    private List<String> threeEx() {
        var tmp = aOrB();
        int tmp1 = tmp.getKey();
        var tmpLst = tmp.getValue();

        boolean isBreak = true;
        do {
            int n3 = random.nextInt(MaxNo) + 1;
            int tmp2 = 0;
            if ((tmp1 + n3) <= MaxNo || (tmp1 - n3) > 0) {
                isBreak = false;
                if ((tmp1 + n3) <= MaxNo) {
                    tmpLst.add("+");
                    tmp2 = tmp1 + n3;
                } else {
                    tmpLst.add("-");
                    tmp2 = tmp1 - n3;
                }
                tmpLst.add(String.valueOf(n3));
                tmpLst.add("=");
                tmpLst.add(String.valueOf(tmp2));
            }
        } while (isBreak);
        return tmpLst;
    }
}
