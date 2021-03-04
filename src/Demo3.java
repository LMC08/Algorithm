import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Demo1
 * @Description: 找出最长回文
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo3 {
    public static void main(String[] args) {
        String str = "abdbcbdassssssabbbbbbas";
        System.out.println(getMaxLongReturnStr(str));
    }

    private static String getMaxLongReturnStr(String s) {
        String returnStr = "没有回文";
        int maxSize = 0;
        if (s.length() == 1) {
            returnStr = s;
        } else if (s.length() > 1) {
            char[] str = s.toCharArray();
            for (int i = 0; i < str.length; i++) {
                for (int j = str.length - 1; j > i; j--) {
                    if (str[i] == str[j]) {
                        String s1 = s.substring(i, j) + str[j];
                        char[] sChar = s1.toCharArray();
                        for (int x = 0; x <= sChar.length / 2; x++) {
                            if (sChar[x] != sChar[sChar.length - 1 - x]) {
                                break;
                            }
                            if (x == sChar.length / 2) {
                                if (sChar.length > maxSize) {
                                    maxSize = sChar.length;
                                    returnStr = String.valueOf(sChar);
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnStr;
    }
}
