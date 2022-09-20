package hots;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @FileName: FirstMissingPositive41
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/19 20:30
 */
//LK 字节原题
//TODO: 待写
public class FirstMissingPositive41 {

    /**
     * 用置换的方式
     * 每次把正确的元素放到正确的位置
     * 第一个未出现的正整数，一定是和数组的长度是有关系的。并不是和数组内的最大值相关的
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++){
            // 处理就是找真正的位置
            while(nums[i]!=i+1){
                if(nums[i]>nums.length) break;
                if(nums[i]==i+1) break;
                if(nums[i]<=0) break;
                if(nums[nums[i]-1]!=nums[i])swap(nums,nums[i]-1,i);
                else break;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1 ;
        }

        return nums.length+1;

    }


    public void swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
