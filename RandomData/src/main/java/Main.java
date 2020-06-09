import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        tt();
    }

    private static void tt() {
        int Max = 9999999;
        int n = 3;
        String mStr = String.valueOf(Max);
        int min = ((int) Math.pow(10, mStr.length() - 1));
        for (int i = Max; i > min; i--) {
            char[] nums = String.valueOf(i).toCharArray();
            char[] t1 = String.valueOf(i * n).toCharArray();
            boolean jamp = false;
            for (int j = 1; j < nums.length; j++) {
                if ((t1.length - nums.length) >= 1 || nums[j] != t1[j - 1]) {
                    jamp = true;
                    break;
                }
            }
            if (jamp) continue;
//            if (t1[t1.length - 1] == '9') {
            System.out.println(i+"    "+i*n);
//            }
        }
    }

}
