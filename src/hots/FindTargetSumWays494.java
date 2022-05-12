package hots;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 */
public class FindTargetSumWays494 {
    /**
     * 思考用dfs行不行
     * 能不能上记忆化搜索
     * @param nums
     * @param target
     * @return
     */
    private  int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {


        dfs(nums,0,target,0);
        return ans;
    }

    public void dfs(int []nums,int index,int target,int sum){
        if (index==nums.length){
            if (sum==target) ans++;
            return;
        }
        dfs(nums,index+1,target,sum+nums[index]);
        dfs(nums,index+1,target,sum-nums[index]);
    }


    /**
     * 用01背包的动态规划方式来解决这道题
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysDynamic(int[] nums, int target) {

        int sum= 0 ;
        for(int num:nums) sum+=num;

        int neg = (sum-target)/2;
        int [][]dp = new int[nums.length+1][neg+1];


        for (int i = 0; i <=nums.length; i++) {
            for (int j = 0; j < neg; j++) {
                if (i==0&&j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=0;
                else{
                    if (nums[i]>j){
//                        不能选择
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
//                        可选可不选
                        dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i]];
                    }
                }

            }
        }

        return dp[nums.length][neg];
    }
}
