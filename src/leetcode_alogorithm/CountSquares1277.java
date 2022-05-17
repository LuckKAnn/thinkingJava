package leetcode_alogorithm;

/**
 * @FileName: CountSquares1277
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/17 10:22
 */

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class CountSquares1277 {

    /**
     * 这道题和221的想法和思路都差不多
     * 同样，其情景也差不多，都是对于只具有0/1的二维矩阵，计算正方形的情况。
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==1){
                //    如果是1的话
                  dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]))+1;
                  cnt+=dp[i+1][j+1];
                }
                else {
                    dp[i+1][j+1]=0;
                }
            }
        }
        return cnt;
    }

    /**
     * 如何原地修改,原地修改的情况，就是矩阵没有这么大了，就需要注意边界情况了。
     * @param matrix
     * @return
     */
    public int countSquares02(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==1){
                    //    如果是1的话
                    if (i!=0&&j!=0){
                        matrix[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]))+1;
                    }
                    cnt+=matrix[i][j];
                }
            }
        }
        return cnt;
    }
}
