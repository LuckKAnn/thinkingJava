package offer;

/**
 * @FileName: Doffer43CountDigitOne
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/8 11:05
 */

/**
 * 剑指 Offer 43. 1～n 整数中 1 出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class Doffer43CountDigitOne {

    /**
     * 这道题实际上可以当做一道规律题
     * 总结数字的规律，1出现的次数，其实可以按照每一位来进行计算
     * 如果当前计算的位，值为0，是什么情况  -------------》 (high)*digit(当前位的十进制数) 可以自己去推，这里其实就是只有
     * 值为1，是什么情况， ----------------> （high*digit+low+1）   1是自己这一位，low是因为如果这一位是1，那1+low都含有1 （仅仅是计算这一位，不需要考虑11的情况）
     * 值为2-9，是什么情况 ------------------->(high+1)*digit  因为2-9说明前面经过了1，所以要+1
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int count = 0;
        int high = n/10;
        int low = 0;
        int mid = n%10;
        int times = 1;
        while(high!=0||mid!=0){

            if(mid==0){
                count+=(high*times);
            }
            else if(mid==1){
                count+=(high*times+low+1);
            }
            else{
                count+=(high+1)*times;
            }
            low = mid*times+low;
            mid = high%10;
            high/=10;
            times*=10;

        }

        return count;

    }
    public static void main(String[] args) {

    }
}
