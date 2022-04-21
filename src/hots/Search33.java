package hots;

/**
 * @FileName: Search33
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/20 10:44
 */

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 */
public class Search33 {

    /**
     * 用二分法来实现功能
     *
     * 假如说二分的mid值，比右侧的界限小： 说明没断？此时要找target，就利用正常的二分法对比
     *                 比右侧的界限大: 说明此处断了？ 此时要找raget，要利用反向的二分法对比
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            /**
             * 注意这里踩到坑了，需要小心，位运算，移位运算的优先级都比较低，最好每次使用都去增加括号，否则可能出错
             */
            //int mid =(high-low)>>1+low;
            int mid =((high-low)>>1)+low;
            //int mid =(high-low)/2+low;
            if (nums[mid]==target) return mid;
            /**
             * 通过mid和左值的关系，来确定一个顺序正确的区间。
             */
            if (nums[mid]>=nums[low]){
            //说明low-->mid这一段是递增的
                if (target<nums[mid]&&target>=nums[low]){
                    high = mid-1;
                }
                else low = mid+1;
            }
            else{
            //    说明low--->mid这一段之间有变化,但是mid--->high这一段是递增的
                if (nums[mid]<target&&target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }

        return -1;
    }

}
