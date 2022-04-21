package hots;

/**
 * @FileName: SearchRange34
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/20 11:40
 */
public class SearchRange34 {
    int start = -1;
    int end = -1;
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            int mid =  ((high-low)>>1)+low;

            if (nums[mid]==target){
            //    判断上下
                for (int i = mid; i >=0 ; i--) {
                    if (nums[i]==target) start = i;
                    else  break;
                }
                for (int i = mid; i <nums.length ; i++) {
                    if (nums[i]==target) end = i;
                    else  break;
                }
                return new int[]{start,end};
            }
            else if (nums[mid]<target) low = mid+1;
            else  high = mid-1;
        }

        return new int[]{start,end};
    }
}
