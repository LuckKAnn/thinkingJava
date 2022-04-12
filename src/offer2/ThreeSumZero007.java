package offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName: ThreeSumZero007
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/11 11:29
 */
public class ThreeSumZero007 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums==null||nums.length<3) return  ans;
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int low = i+1;
            int high = nums.length-1;
            while (low<high){
                int tmpSum = nums[i]+nums[low]+nums[high];
                if (tmpSum==0){
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[low]);
                    t.add(nums[high]);
                    ans.add(t);
                    low++;
                    high--;
                    while (high>low&&nums[high]==nums[high+1]) high--;
                    while (high>low&&nums[low]==nums[low-1]) low++;
                }
                else if (tmpSum>0){
                    high--;
                    while (high>low&&nums[high]==nums[high+1]) high--;
                }
                else{
                    low++;
                    while (high>low&&nums[low]==nums[low-1]) low++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSumZero007 threeSumZero007 = new ThreeSumZero007();
        //int []arr = {-1,0,1,2,-1,-4};
        int []arr = {-2,0,0,2,2};
        List<List<Integer>> lists = threeSumZero007.threeSum(arr);
        System.out.println(lists.toString());
    }
}
