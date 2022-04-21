package offer2;

/**
 * @FileName: SubarraySum10
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/21 10:41
 */
public class SubarraySum10 {

    /**
     * dp[i][j] 表示i-->j的int数据能够构成的数字
     *
     * dp[i][j] = {
     *
     * }
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0 ;
        int left = 0;
        int right = 0;
        int tmp  = nums[0]  ;
        while (left!=nums.length){

            if (tmp==k){
                ans++;
               if (right<nums.length-1){
                   right++;
                   tmp+=nums[right];
               }
               else {
                   tmp-=nums[left];
                   left++;
               }
            }
            else if (tmp<k){
                //做加法
                if (nums[left]<0||right==nums.length-1){
                    tmp-=nums[left];
                    left++;
                }
                else{
                    right++;
                    tmp+=nums[right];
                }
            }
            else{
                //做减法
                tmp-=nums[left];
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySum10 subarraySum10 = new SubarraySum10();
        System.out.println(subarraySum10.subarraySum(new int[]{-1,-1,1}, 0));
    }
}
