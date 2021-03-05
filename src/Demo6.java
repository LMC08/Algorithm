import java.util.Arrays;

/**
 * @ClassName: Demo6
 * @Description: 包含n个数的数组nums，找出nums中是否存在三个元素相加等于0，找出所有和为0且不重复的三元组
 *                      eg.nums[-1,0,1,2,-1,-4]   [[-1,-1,2],[1,-1,0]]
 *                         nums[0]  []
 *                         nums[]   []
 * @Author liminchuan
 * @Date:Create： 2021/3/2 8:45
 */
public class Demo6 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }

//    首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
//    如果 nums[i[大于 0，则三数之和必然无法等于 0，结束循环
//    如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
//    当 sum==0 时，nums[L] == nums[L+1]则会导致结果重复，应该跳过，L++
//    当 sum== 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
    private static void threeSum(int[] nums) {
        int len = nums.length;
        //先进行排序
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            //大于0提前结束
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    System.out.println(nums[i] + "," + nums[left] + "," + nums[right]);
                    //数字一样跳过 防止重复
                    if (nums[left] == nums[left + 1])
                        left++;
                    if (nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                }
                //小 右移
                else if (sum < 0) left++;
                    //大 左移
                else right--;
            }
        }
    }

}
