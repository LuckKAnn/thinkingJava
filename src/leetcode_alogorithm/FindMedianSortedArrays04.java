package leetcode_alogorithm;

/**
 * @FileName: FindMedianSortedArrays04
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/12 10:29
 */

/***
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 */
public class FindMedianSortedArrays04 {
    /**
     * 用类似于归并排序的方法去解决
     * 时间复杂度是否同归并排序
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int mid = (nums1.length+nums2.length)/2;
        double ans = 0.0;
        int cnt = 0;
        int left = 0;
        int right = 0;
        int i=0,j=0;
        int tmp = 0;
        while (i<nums1.length||j<nums2.length){

            if (i==nums1.length){
                tmp = nums2[j];
                j++;
            }
            else if(j==nums2.length){
                tmp=nums1[i];
                i++;
            }
            else if(nums1[i]<nums2[j]){
                tmp = nums1[i];
                i++;
            }
            else{
                tmp = nums2[j];
                j++;
            }

            if (cnt==mid) left=tmp;
            else if(cnt==mid-1) right = tmp;
            else if(cnt>mid+1) break;
            cnt++;
        }

        if(((nums1.length+nums2.length)&1)==1){
        //    如果是奇数，那么取left即可
            return  (double) left;
        }
        else{
            return (double) (left+right)/2;
        }

    }
}
