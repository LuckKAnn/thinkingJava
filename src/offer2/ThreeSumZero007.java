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

/**
 * 经典题目三数之后
 * 特性就是固定一个点，找寻其他的点，为了防止重复，在更新的时候进行逻辑判断
 *
 * 解法名称算是: 排序+双指针
 */
public class ThreeSumZero007 {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums==null||nums.length<3) return  ans;
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length-2; i++) {
            //提前结束的一些逻辑
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int low = i+1;
            int high = nums.length-1;
            while (low<high){
                int tmpSum = nums[i]+nums[low]+nums[high];
                if (tmpSum==0){
                    ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low++;
                    high--;
                    while (high>low&&nums[high]==nums[high+1]) high--;
                    while (high>low&&nums[low]==nums[low-1]) low++;
                }
                else if (tmpSum>0){
                    high--;
                    //为什么这里可以不用，因为即使是相同的元素，由于不满足==0的条件，所以就算重复了也不会有影响
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
        List<List<Integer>> listss = threeSumZero007.threeSum(null);
        System.out.println(lists.toString());
    }
}
