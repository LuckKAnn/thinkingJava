package hots;

/**
 * @FileName: MaximalSquare221
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/16 10:49
 *
 *
 *
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaximalSquare221 {
    /**
     * 还是得想想能不能用前缀和的方式来解决
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][]sum= new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //    sum[i+1][j+1] = sum[i+1][j]+sum[i][j+1]-sum[i][j]+num[][];
                //    tmp = 0;
                sum[i+1][j+1] =  sum[i+1][j]+sum[i][j+1]-sum[i][j]+(matrix[i][j]-'0');
            }
        }

        //    有了二维前缀和，现在应该怎么做呢？
        //    枚举起点和中点吗
        int len  = Math.min(m,n);

        //遍历所有为1的点？
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j]=='1'){
                    ans = Math.max(ans,1);
                    int rr = i+1;
                    int rc = j+1;
                    while (rr<m&&rc<n){
                        int area = (rr-i+1)*(rr-i+1);
                        int sumArea = sum[rr+1][rc+1]-sum[i][rc+1]-sum[rr+1][j]+sum[i][j];
                        if (area==sumArea){
                            ans = Math.max(ans,area);
                        }
                        else break;
                        rr++;
                        rc++;
                    }

                }
            }
        }

        return ans;
    }

    /**
     * LK: 这道题如果用动态规划的思想来做，就十分的简单和明确
     * @param matrix
     * @return
     */
    public int maximalSquare02(char[][] matrix) {
        int ans = 0;
        /**
         * 可以优化，降低空间复杂度，但是需要额外的对i=0和j=0的情况进行边界处理
         */
        int [][]dp = new int[matrix.length+1][matrix[0].length+1];

        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                if (matrix[i][j]=='1'){
                //    如果是1
                    dp[i+1][j+1] = Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]))+1;
                    ans = Math.max(ans,dp[i+1][j+1]*dp[i+1][j+1]);
                }
                else{
                    dp[i+1][j+1] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char [][]arr = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        MaximalSquare221 m = new MaximalSquare221();
        System.out.println(m.maximalSquare02(arr));
    }
}
