package offer;

/**
 * @FileName: Offer66
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/1 9:34
 */

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A
 * 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 */
public class Offer66 {

    /**
     * 核心思路，将数据拆分成两部分
     * 左边left，依次增高的
     * 右边right 存在减的情况，为了让他不减少的话，我们可以从右往左算，这样就是递增的了，
     * 然后保存起来即可。
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int []right = new int[a.length];
        int tmp = 1;
        for(int i = a.length-1;i>=0;i--){
            tmp*=a[i];
            right[i] = tmp;
        }

        int left = 1;


        for(int i=0;i<a.length;i++){
            tmp = a[i];
            if(i!=a.length-1){
                a[i] = left*right[i+1];
            }
            else{
                a[i] = left;
            }

            left*=tmp;
        }

        return a;
    }
}
