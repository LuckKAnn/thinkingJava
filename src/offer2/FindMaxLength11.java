package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: FindMaxLength11
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/21 11:13
 */
public class FindMaxLength11 {

    public int findMaxLength(int[] nums) {
        int ans = 0;
        Map<Integer,Integer> preSum = new HashMap<>();
        int counter = 0;
        preSum.put(0,-1);
        for (int i = 0; i <=nums.length; i++) {
            //pre+=nums[i];
            if (nums[i]==0){
                counter--;
            }
            else  counter++;


            if (preSum.containsKey(counter)){
                Integer pre = preSum.get(counter);
                ans = Math.max(ans,i-pre);
            }
            else preSum.put(counter,i);  //总是放最前面的数
        }
        return ans;
    }
}
