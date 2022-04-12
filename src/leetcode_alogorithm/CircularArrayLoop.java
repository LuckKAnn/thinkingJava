package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 19:49 2021/9/4
 * @email: 1546165200@qq.com
 */

/**
 * 457. 环形数组是否存在循环
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 *
 * 如果 nums[i] 是正数，向前（下标递增方向）移动 |nums[i]| 步
 * 如果 nums[i] 是负数，向后（下标递减方向）移动 |nums[i]| 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 *
 * 数组中的 循环 由长度为 k 的下标序列 seq 标识：
 *
 * 遵循上述移动规则将导致一组重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(havecircular(nums,i)) return true;
        }
        return false;

    }
    public boolean havecircular(int[] nums,int index){
        int tmp = index;
        boolean flag = nums[index]>0;
        int count = 0;
        while(true){
            count++;
            tmp  = calLocation(nums,tmp);
            if(count>nums.length) return false;
            if(flag&&nums[tmp]<0) return false;
            if(!flag&&nums[tmp]>0) return false;
            if(tmp==index) return count>1;
        }
    }
    public int calLocation(int []nums,int index){
        //本题最关键的一个点，对于一个数组，假如数组当中的数为正负移动距离，那么其下一个位置的计算方式如下，三次出现长度，两次取余，一次加
        return ((index+nums[index])%nums.length+nums.length)%nums.length;
    }
}
