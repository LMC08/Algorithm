/**
 * @ClassName: Demo2
 * @Description: 找出两个有序数组合并后的中位数
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo2 {

    public static void main(String[] args) {
        int[] i = {2, 3, 4, 5};
        int[] j = {7, 8, 9};
        double d = findMedianSortedArrays(i, j);
        System.out.println("中位数：" + d);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i;
        int p = 0;
        int q = 0;
        double[] nums = new double[m + n];

        //两个有序数组合并,用归并排序
        for (i = 0; i < m + n; i++) {
            if ((p + 1 <= m) && (q + 1 <= n)) {
                if (nums1[p] < nums2[q]) {
                    nums[i] = nums1[p];
                    p++;
                } else {
                    nums[i] = nums2[q];
                    q++;
                }
            } else if (p + 1 <= m) {
                nums[i] = nums1[p];
                p++;
            } else if (q + 1 <= n) {
                nums[i] = nums2[q];
                q++;
            }
        }
        if ((m + n) % 2 == 0) {
            return (nums[(m + n) / 2 - 1] + nums[(m + n) / 2]) / 2;
        } else {
            return nums[(m + n - 1) / 2];
        }
    }
}
