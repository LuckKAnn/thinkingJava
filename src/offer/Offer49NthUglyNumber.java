package offer;

/**
 * @FileName: Offer49NthUglyNumber
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/6 16:25
 */
public class Offer49NthUglyNumber {

    /**
     * 第n个丑数
     * 丑数的质因子只包含有2，3，5
     * 那么所有的丑数都是由之前的丑数乘以2、3、5得到
     * 每次都先找最小的那一个加入进集合即可。
     * 三指针法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int []ugly = new int[n];
        ugly[0]=1;
        for (int i = 1; i < n; i++) {
            ugly[i] =Math.min(ugly[a]*2,Math.min(ugly[b]*3,ugly[c]*5));
            if (ugly[a]*2==ugly[i]) a++;
            if (ugly[b]*3==ugly[i]) b++;
            if (ugly[c]*5==ugly[i]) c++;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ugly[i]);
        }

        return ugly[n-1];
    }

    public static void main(String[] args) {
        Offer49NthUglyNumber offer49NthUglyNumber = new Offer49NthUglyNumber();
        offer49NthUglyNumber.nthUglyNumber(12);
    }
}
