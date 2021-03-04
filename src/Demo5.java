/**
 * @ClassName: Demo1
 * @Description: 找出最长前缀
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo5 {
    public static void main(String[] args) {
        String[] str = {"fly", "fl", "f"};
        System.out.println(findMaxLong(str));
    }

    private static String findMaxLong(String[] str) {
        String reStr = "";
        if (str.length >= 2) {
            char[] char1 = str[0].toCharArray();
            char[] char2 = str[1].toCharArray();
            if (char1.length >=char2.length) {
                for (int i = 0; i < char2.length; i++) {
                    if (char1[i] == char2[i]) {
                        reStr += String.valueOf(char1[i]);
                    } else {
                        break;
                    }
                }
            } else {
                for (int i = 0; i < char1.length; i++) {
                    if (char1[i] == char2[i]) {
                        reStr += String.valueOf(char1[i]);
                    } else {
                        break;
                    }
                }
            }
            if (!"".equals(reStr) && str.length > 2) {
                String s ="";
                char[] reStrChar = reStr.toCharArray();
                for (int i = 2; i < str.length; i++) {
                    char[] chx = str[i].toCharArray();
                    if(reStrChar.length>=chx.length){
                        for(int n = 0 ;n<chx.length;n++){
                            if(reStrChar[n] == chx[n]){
                                s+=chx[n];
                            }else {
                                break;
                            }
                        }
                    }else {
                        for(int n = 0 ;n<reStrChar.length;n++){
                            if(reStrChar[n] == chx[n]){
                                s+=chx[n];
                            }else {
                                break;
                            }
                        }
                    }
                    if(s.length()<reStr.length()){
                        reStr = s;
                    }
                }
            }
        }
        return reStr;
    }
}
