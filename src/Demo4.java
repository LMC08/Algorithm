/**
 * @ClassName: Demo1
 * @Description: 找出字符串中的数字，如果开头是字母返回0；超出int界限返回上界或下界
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo4 {
    public static void main(String[] args) {
        String s1 = "123 abc";
        String s2 = " abc12";
        String s3 = "  +12 pass";
        String s4 = " -22 pass";
        String s5 = " 0023 pass";
        String s6 = " 9147883647";
        String s7 = " -9147883647";
        String s9 = " 25+34";
        String s10 = " 25-avvv";
        System.out.println(getNum(s1));
        System.out.println(getNum(s2));
        System.out.println(getNum(s3));
        System.out.println(getNum(s4));
        System.out.println(getNum(s5));
        System.out.println(getNum(s6));
        System.out.println(getNum(s7));
        System.out.println(getNum(s9));
        System.out.println(getNum(s10));
    }

    private static int getNum(String s) {
        String num = "";
        String mark = "";
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if ("0123456789".indexOf(c) > -1) {
                num += c;
            } else {
                if ("-".equals(String.valueOf(c)) || "+".equals(String.valueOf(c))) {
                    if ("".equals(num)) {
                        mark = String.valueOf(c);
                    } else {
                        break;
                    }
                } else {
                    if (!" ".equals(String.valueOf(c))) {
                        break;
                    }
                }
            }
        }
        if (!"".equals(num)) {
            if (Double.parseDouble(mark + num) > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (Double.parseDouble(mark + num) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt(mark + num);
            }
        } else {
            return 0;
        }
    }
}
