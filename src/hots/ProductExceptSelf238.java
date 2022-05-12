package hots;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductExceptSelf238 {

    /**
     * 思路:原来正向的话可以把前缀元素的乘积逐步的搞上去，那么同样的道理，也可以通过反向遍历的方式，把后缀元素的乘积逐步加上去
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int tmp = 1;
        int []ans = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            ans[i]=1;
            ans[i]*=tmp;
            tmp*=nums[i];
        }

        tmp = 1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=tmp;
            tmp*=nums[i];
        }

        return ans;

    }
}
