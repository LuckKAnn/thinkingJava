package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 16:32 2021/9/20
 * @email: 1546165200@qq.com
 */

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 *
 * ****************************************面试常考题
 */
public class XXLengthOfLIS {

    /**
     * 自己的思路。DP
     * 找最后一步，最后一个元素j，他能够形成的最长递增子序列长度x
     * 是任意的i小于j，并且nums[i]<nums[j]，中dp[j]最大的一个，如果这个dp[j]为0，那么x为1，否则x为dp[j]+1
     * 之后再遍历一次找最大值
     * 初始的时候dp[0]=1;
     * @param nums
     * @return
     */


    public int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            int tmpMax = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]&&dp[j]>tmpMax){
                    tmpMax = dp[j];
                }
            }
            if(tmpMax==0){
                dp[i] = 1;
            }
            else{
                dp[i]=tmpMax+1;
            }
        }
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;

    }


    /**
     * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
     * 官方解答类似
     */
    public int lengthOfLISOff(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    /**
     * O(NlogN) 时间复杂度的算法，采用了二分法
     *考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
     *
     * 基于上面的贪心思路，我们维护一个数组 d[i]d[i] ，表示长度为 ii 的最长上升子序列的末尾元素的最小值，用 \textit{len}len 记录目前最长上升子序列的长度，起始时 lenlen 为 11，d[1] = \textit{nums}[0]d[1]=nums[0]。
     * 也就是说维护的是，，表示长度为 ii 的最长上升子序列的末尾元素的最小值，
     * 最后得到的最长长度，那就是最长子序列的长度
     * @param nums
     * @return
     */
    public int lengthOfLISBinary(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    public  int binaryInsert(int []nums,int target){
        int i = 0, j = nums.length;
        while(i < j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m;
        }

        return  i;
    }

    /***
     * 注意观察这两个方法，他们的高点不一样，判断条件不一样，但是他们返回的点都是低点
     * @param nums
     * @param target
     * @return
     */
    public  int binaryInsert2(int []nums,int target){
        int i = 0, j = nums.length-1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m-1;
        }

        return  i;
    }


    /**
     * 自改二分搜索来计算最长递增子序列
     * @param nums
     * @return
     */
    public int lengthOfLISOFFbinaryMine(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for(int num : nums) {
                int low = 0, high = res-1;
                while(low <= high) {
                    int mid = (low + high) / 2;
                    if(tails[mid] < num) low = mid + 1;
                    else high = mid-1;
                }
                tails[low] = num;
                if(res == low) res++;
            }
            return res;
    }



    public static void main(String[] args) {
        XXLengthOfLIS xxLengthOfLIS = new XXLengthOfLIS();
        int []arr = {0,1,0,3,2,3};
        // xxLengthOfLIS.binaryInsert2(arr,5);
        int []arr2 = {0,0};
        System.out.println(xxLengthOfLIS.binaryInsert(arr2, 1));
        System.out.println(xxLengthOfLIS.binaryInsert2(arr2,1));
    }

}
