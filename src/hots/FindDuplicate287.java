package hots;

/**
 * @FileName: FindDuplicate287
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/12 11:26
 */
public class FindDuplicate287 {
    /**
     * 这道题可以参考循环链表来做
     *
     * 这道题的问题在于，有n+1个整数，但是数字出现的范围是1-n，所以说数字0是不可能出现的，所以这里能以0而出发
     * 否则的可能出现0的话，那0->0就走不下去了，无法找到循环链表
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);

        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;


    }
}
