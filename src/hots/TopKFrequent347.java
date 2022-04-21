package hots;

/**
 * @FileName: TopKFrequent347
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 10:24
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequent347 {

    /**
     *
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     * 非进阶可以通过堆排序来做，而进阶就不行咯,进阶要通过快速排序的性质来实现
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
      return  nums;
    }

    public int[] topKFrequentHeap(int[] nums, int k){
        Map<Integer, Integer> mp =new HashMap<>();
        for (int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        /**
         * 注意这里数组的用法
         */
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            return -o1[1]+o2[1];
        });

        //快速创建数组的方式
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            priorityQueue.offer(new int[] {entry.getKey(),entry.getValue()});
        }
        int []ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=priorityQueue.poll()[0];
        }
        return ans;
    }

    public int[] topKFrequentQucikSort(int[] nums, int k){
        Map<Integer, Integer> mp =new HashMap<>();
        for (int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        return null;
    }










}
