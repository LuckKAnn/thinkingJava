package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 15:31 2021/9/26
 * @email: 1546165200@qq.com
 */

/**
 * 371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 */
public class GetSumWithoutPlus {
    /**
     * 方法: 将单个位的运算和进位分开。
     * 单个位运算的结果是两者的异或。而进位是两者相与。想要运算结束，需要等到进位为0.
     * 当且仅当进位最大时是逐步一位一位的进位，而取到负数的时候，会需要最大int长度次进位.也就是32次
     * @param a
     * @param b
     * @return
     */
    int count = 0;
    public int getSum(int a, int b) {
        while (b != 0) {

            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
            System.out.println("第"+count+++"次运算,得到结果a:"+a+";b:"+b);
        }
        return a;
    }

    public static void main(String[] args) {
        GetSumWithoutPlus getSumWithoutPlus = new GetSumWithoutPlus();
        System.out.println(getSumWithoutPlus.getSum(1, -1));
    }
}
