/**
 * @ClassName: Demo1
 * @Description: 给定一个数组和一个数字，找出数组中任意两个数的和等于给定数字
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] i = {0,1,2,3,4,5,6};
        int n = 7;
        for(int j=0;j<i.length-1;j++){
            for(int x=j+1;x<i.length;x++){
                if(n==i[j]+i[x]){
                    System.out.println(i[j]+","+i[x]);
                }
            }
        }
     }
}
