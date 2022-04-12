package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LuckKAnn
 * @date : 7:38 PM 7/26/2021
 * @email: 1546165200@qq.com
 *
 *  最长公共子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index = binaySearch(list,nums[i]);
        }
        return -1;

    }

    int binaySearch(List<Integer> list , int target){
        int size = list.size();
        int low = 0,high = size-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(list.get(mid)<target) low =mid+1;
            else high = mid;
        }
        return low;

    }
}
