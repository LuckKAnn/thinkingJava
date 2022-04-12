/**
 * @author : LuckKAnn
 * @date : 10:03 2021/9/21
 * @email: 1546165200@qq.com
 */

/**96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：5

 */
public class NumBinarySearchTrees {
    /**
     * 也就是计算有n个结点构成的二叉搜索树有多少种
     *
     * 两种方法一种动态规划，一种利用数学推理，使用卡特兰数
     *
     *
     * 卡特兰数: Cn+1 = 2*(2n+1)*Cn/n+2
     *
     */
    public int numTrees(int n) {
        /**
         * 动态规划，以某个结点为中间节点，拆分为左右两部分子问题，子问题可以重用
         */

        int []ret = new int[n+1];
        ret[0]=1;
        for(int i=1;i<=n;i++){
            int tmp = 0;
            for(int j=1;j<=i;j++){
                tmp+=ret[j-1]*ret[i-j];
            }
            ret[i]=tmp;
        }
        return ret[n];

    }

}
