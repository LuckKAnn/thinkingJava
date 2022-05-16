package hots;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: NumSquares279
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/16 11:30
 */
public class NumSquares279 {


    Set<Integer> set = new HashSet<>();
    public int numSquares(int n) {
    //    用数组暂存离得最近的完全平方数

       int []dp = new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int sqrt =(int) Math.sqrt(i);
            int tmp  = (int) Math.pow(sqrt,2);
            if (tmp==i){
            //    这个数是一个完全平方数
                set.add(i);
                dp[i]=1;

            }
            else{
                dp[i]=Integer.MAX_VALUE;
                //如果不是，就找一个最近的,需要遍历
                for(int q :set){
                    dp[i] = Math.min(dp[i],dp[i-q]+1);
                }
            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares279 numSquares279 = new NumSquares279();
        System.out.println(numSquares279.numSquares(12));
    }
}
