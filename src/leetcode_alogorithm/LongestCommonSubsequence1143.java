package leetcode_alogorithm;

/**
 * @FileName: LongestCommonSubsequence1143
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/12 10:37
 */
//TODO:字节面试题

/**
 * 典型的二维动态规划问题
 */
public class LongestCommonSubsequence1143 {


    /**
     * 序列DP的问题？
     *
     * dp[i][j] = {
     *              if ti==tj    dp[i][j] = dp[i-1][j-1]+1
     *              if t1!=tj    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
     *
     * }
     *  边界条件0
     *
     *  改进，可以将调用的函数都提前静态化
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp = new int[text1.length()+1][text2.length()+1];
        dp[0][0]=0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else{
                    //这里相当于任意去删除一个字符？
                    //dp[i][j+1]相当于删除text1的一个字符时，构成的最长子序列？
                    //dp[i+1][j]相当于删除text2的一个字符时，构成的最长子序列？
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);

                }
            }
        }

        return  dp[text1.length()][text2.length()];
    }



    public static void main(String[] args) {
        LongestCommonSubsequence1143 l = new LongestCommonSubsequence1143();
        System.out.println(l.longestCommonSubsequence("abcde", "ace"));
        System.out.println(l.longestCommonSubsequence("abc", "abc"));
        System.out.println(l.longestCommonSubsequence("abc", "def"));
    }
}
