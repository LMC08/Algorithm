import java.util.HashMap;

/**
 * @ClassName: Demo1
 * @Description: 给定一个数组和一个数字，找出数组中任意两个数的和等于给定数字
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] i = {0, 1, 2, 3, 4, 5, 6};
        int n = 7;
        sum(i, n);
        //暴力算法
//        for(int j=0;j<i.length-1;j++){
//            for(int x=j+1;x<i.length;x++){
//                if(n==i[j]+i[x]){
//                    System.out.println(i[j]+","+i[x]);
//                }
//            }
//        }
    }

    //解决暴力
    private static void sum(int[] nums, int tarNum) {
        //首先使用哈希map，存储数组的元素和该元素对应的下角标
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        //遍历数组，找到第二个元素的位置
        for (int i = 0; i < nums.length; i++) {
            //定义一个数字j,用于记录第二个元素的位置,第一个元素为i不用专门记录
            Integer j = map.get(tarNum - nums[i]);
            //如果j是位于i的后面并且j存在，就把两个元素各加一并返回
            if (j != null && j > i) {
                System.out.println(nums[i] + "," + nums[j]);
            }
        }
    }
}
