/**
 * @ClassName: Demo1
 * @Description: 找出两个数组合并后的中位数
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo2 {

    public static void main(String[] args) {
        int[] i = {2, 3, 4, 5};
        int[] j = {7, 8, 9};
        double d = getMiddleNum(i, j);
        System.out.println("中位数：" + d);
    }

    private static double getMiddleNum(int[] i, int[] j) {
        double d = 0;
        int iLen = i.length;
        int jLen = j.length;
        if (iLen > 0 && jLen > 0) {
            int[] n = new int[iLen + jLen];
            System.arraycopy(i, 0, n, 0, iLen);
            System.arraycopy(j, 0, n, iLen, jLen);
            for (int x = 0; x < n.length; x++) {
                for (int z = x + 1; z < n.length; z++) {
                    if (n[x] > n[z]) {
                        n[x] = n[z] + n[x];
                        n[z] = n[x] - n[z];
                        n[x] = n[x] - n[z];
                    }
                }
            }
            for (int x:n){
                System.out.print(x+",");
            }

            if (n.length % 2 == 0) {
                d = (n[n.length / 2 - 1] + n[n.length / 2]) / 2.0;
            } else {
                d = n[n.length / 2];
            }
        } else {
            if (iLen > 0) {
                if (iLen % 2 == 0) {
                    d = (i[iLen / 2 - 1] + i[iLen / 2]) / 2.0;
                } else {
                    d = i[iLen / 2];
                }
            } else if (jLen > 0) {
                if (jLen % 2 == 0) {
                    d = (j[jLen / 2 - 1] + j[jLen / 2]) / 2.0;
                } else {
                    d = j[jLen / 2];
                }
            } else {
                System.out.println("数据不正确，没有中位数");
            }
        }
        return d;
    }
}
