import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExcelUtilsTest {

    @Test
    void toExcel() {
        List<MyItem> lst = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MyItem item = new MyItem("name:" + i, "details:" + i, i);
            lst.add(item);
        }
        String path = "f:\\test.xls";

        ExcelUtils.getInstance().toExcel(path, new ArrayList<List<MyItem>>() {{
            add(lst);
        }});
    }
}