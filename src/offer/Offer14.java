package offer;

/**
 * @FileName: Offer14
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/30 9:44
 */

/**
 * 剑指 Offer 14- II. 剪绳子 II
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * ********************************
 * 这道题相较于前一道剪绳子，其范围更大，涉及到取模的知识，但是核心的思路还是不变，优先减3，再减2
 * 减3剩1时，需要取4
 * ************************************
 * 可以注意一下其公式推导的方式，用到了均值不等式，求函数极大值(求导)等方法
 */
public class Offer14 {


    public static final int MOD = 1000000007;
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        Long ans = 1L;
        for (int i = 0; i < n/3 - 1; i++) {
            ans=(ans*3)%MOD;
        }
        if(n%3==0) return (int)(ans*3%MOD);
        else if(n%3==1) return  (int)(ans*4%MOD);
        else return (int)(ans*6%MOD);
    }
}
