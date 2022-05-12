package leetcode_alogorithm;

/**
 * @FileName: FindMedianSortedArrays04
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/12 10:29
 */
public class FindMedianSortedArrays04 {

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
