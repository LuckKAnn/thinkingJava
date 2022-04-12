package leetcode_alogorithm;

/**
 * @FileName: Jump45
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 19:19
 */
public class Jump45 {

    /**
     *
     * 正向用O(n)的时间复杂度
     * 核心在于用贪心，用局部最优，
     * 什么意思: 从第0位开始，其能够确定一步所到达的最大距离，那在这个范围内的跳跃，最小都一定是这个步数
     * 之后计算这个范围能再跳最大的范围，这个范围内的都是经过步数+1能够到达的
     * }
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
         int far = 0;
         int max = 0;
         int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            max = Math.max(max,nums[i]+i);
            if (i==far){
                far=max;
                count++;
            }
        }
        return count;

    }
}
