package hots;

import java.util.Arrays;
import java.util.Random;

/**
 * @FileName: FindKthLargest215
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/20 9:21
 */

/**
 *
 * LK 用快速排序的思想来做寻找第K大的元素
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 */
public class FindKthLargest215 {


    /**
     * 能否利用快速排序，排序到位置K的就行了
     * 通过快速排序的分治法来解决这个问题。因为要找排序完之后的第K个数，那么仅仅需要关注这个位的数在分治的过程中是否被确定即可
     * @param nums
     * @param k
     * @return
     */
    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {

        quickSort(nums,0,nums.length-1,nums.length-k);

        return nums[nums.length-k];
    }

    public void quickSort(int []nums,int low,int high, int k){
        if (low<high){
            int pivot = partion(nums,low,high);
            if (pivot<k) quickSort(nums,pivot+1,high,k);
            else if (pivot>k) quickSort(nums,low,pivot-1,k);
            else return;
        }

    }

    public int partion(int []nums,int low,int high){
        //int pivot = nums[low];
        int randIndex = random.nextInt(high-low+1)+low;
        int pivot = nums[randIndex];
        swap(nums,low,randIndex);
        while (low<high){
            //注意这里是包含了等于
            //如果不包含等于可能出现死循环的情况，low和high都指向了与pivot相同的数，这就导致来回的交换
            while (low<high&&nums[high]>=pivot) high--;
            nums[low] = nums[high];
            while (low<high&&nums[low]<=pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    public void  swap(int []nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]= tmp;
    }

    public static void main(String[] args) {
        FindKthLargest215 findKthLargest215 = new FindKthLargest215();

        System.out.println(findKthLargest215.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }

}
