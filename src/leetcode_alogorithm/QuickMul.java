package leetcode_alogorithm;

/**
 * @FileName: QuickMul
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/12 17:01
 */

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *
 * ********快速幂迭代算法
 * 恰好就对应了 77的二进制表示 (1001101)，由分析可以知道，每一个有1的地方的十进制数字a，都需要计算成一个x的a次方，最后将所有这些数相乘就可以得到最终的结果
 *
 *
 *
 * **********这道题更容易理解的方式是递归
 * 从后往前开始运算，对于77，其实质是由38*2+1得到的，38是由19*2得到的，19是由9*9+1得到的
 * 所以实际上，要计算n次幂，如果n是偶数，那么要计算其一半的次幂平方即可，如果n是奇数，还需要其一半的次幂平方再乘一次x
 * 由于每次可以减半，时间复杂度是o logN
 */
public class QuickMul {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            //二进制位的计算
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            //每一次二进制运算，都需要通过乘来计算数值。比如1，2，4，8，16是二进制各位的位
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }


}
