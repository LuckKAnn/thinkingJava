package leetcode_alogorithm;

import java.util.Random;

/**
 *
 *
 * 398. 随机数索引
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 *
 * 如果数组以文件形式存储（读者可假设构造函数传入的是个文件路径），且文件大小远超内存大小，我们是无法通过读文件的方式，将所有下标保存在内存中的，因此需要找到一种空间复杂度更低的算法。
 *
 * 我们可以设计如下算法实现pick 操作：
 *
 * 遍历nums，当我们第 i次遇到值为 target 的元素时，随机选择区间 [0,i) 内的一个整数，如果其等于 0，则将返回值置为该元素的下标，否则返回值不变。
 *
 * 这种方法能够使得每个值为target的元素被选中的概率都是1/K,其中K是值为target的元素个数。
 * 这道题值得一看的就是这个算法，这种算法能够在数据很大的情况下利用。那么这种场景有适用的空间吗？比如随机抽奖？
 */
public class PoolRandomPick389 {

    int []datas ;
    Random random = new Random();
    public PoolRandomPick389(int[] nums) {
            datas = new int[nums.length];
            
    }

    public int pick(int target) {
        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < datas.length; i++) {
            if (datas[i]==target){
                cnt++;
                if (random.nextInt(cnt)==0){
                    ans = i;
                }
            }
        }

        return ans;
    }
}
