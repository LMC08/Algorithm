import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: Demo5
 * @Description: 找出最长前缀
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo5 {
    public static void main(String[] args) {
        String[] str = {"flya", "flb", "flcd"};
        System.out.println(longestCommonPrefix1(str));
        System.out.println(longestCommonPrefix2(str));

    }

    private static String longestCommonPrefix1(String[] strs) {
        //判断是否为空串
        if (strs == null || strs.length == 0) return "";
        //数组按照字符顺序排序(从小到大)
        List<String> list = Arrays.asList(strs);
        Collections.sort(list);
        //声明一个公共前缀
        String prefix = "";
        //暴力for循环
        outerloop:
        for (int i = 0; i < list.get(0).length(); i++) {
            String tmp = list.get(0).substring(0, i + 1);
            for (int j = 0; j < list.size(); j++) {
                if (!tmp.equals(list.get(j).substring(0, i + 1))) {
                    break outerloop;
                }
                if (j == list.size() - 1) {
                    prefix = list.get(0).substring(0, i + 1);
                    break;
                }
            }
        }
        //返回公共前缀
        return prefix;
    }

    private static String longestCommonPrefix2(String[] strs) {
        //判断是否为空串
        if(strs==null||strs.length==0) return "";
        //找到最短的字符串的长度
        int minLen=Integer.MAX_VALUE;
        for(String str:strs){
            minLen=Math.min(str.length(),minLen);
        }
        int first=1;
        int last=minLen;
        while(first<=last){
            //找到中间位置
            int middle=(first+last)/2;
            if(isCommonPrefix(strs,middle)){
                //前半串是公共子串，则从前半串+1位继续查找
                first=middle+1;
            }else{
                //前半串不是公共子串，则从前半串-1位继续查找
                last=middle-1;
            }
        }

        return strs[0].substring(0, last);
    }
    //判断第一个字符串的前len是否为所有串的子串
    private static boolean isCommonPrefix(String[] strs, int len){
        boolean flag =true;
        String tmp=strs[0].substring(0,len);
        for(int i=1;i<strs.length;i++){
            if(!strs[i].startsWith(tmp)){
                flag= false;
                break;
            }
        }
        return flag;
    }
}

