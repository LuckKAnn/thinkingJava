package offer;

/**
 * @FileName: Offer60
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/1 9:38
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 */
//TODO:思路
public class Offer60Nshaizidedianshu {
    /**
     * 以动态规划的角度来看
     * 每一个出现的骰子，对于之后的情况，都会产生影响
     * 譬如当骰子个数为1 时，所有的数出现的概率都是1/6
     * 但是对于第二个骰子来说，虽然最小的数是2，但是这个2有之前的1产生的影响，1/6*1/6
     * 第二小的数3，由之前的1也可能产生影响，1/6*1/6
     * 而第二小的数3，也会被之前的2产生影响，也就是1/6*1/6*2
     * 数组的长度规律: n*6-n+1
     * @param n
     * @return
     */
    private final double chance = (double) 1/6;
    public double[] dicesProbability(int n) {
        double []dp = new double[6];
        Arrays.fill(dp,chance);
        for (int i = 2; i <=n; i++) {
            double[]tmp = new double[5*i+1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j+k] += dp[j]*chance;
                }
            }
            dp = tmp;
        }
        return  dp;
    }

    public static void main(String[] args) {
        Offer60Nshaizidedianshu offer60Nshaizidedianshu = new Offer60Nshaizidedianshu();
        System.out.println(Arrays.stream(offer60Nshaizidedianshu.dicesProbability(2)));

        for (double v : offer60Nshaizidedianshu.dicesProbability(2)) {
            System.out.println(v);
        }
    }
}
