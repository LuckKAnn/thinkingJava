package offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @FileName: Offer44FindNthDigit
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/6 17:01
 */
public class Offer44FindNthDigit {

    /**
     * 注意几个点:
     *      数据类型，为了防止超出用了long
     *      注意100-999是900个数，不是1000个数
     *      直接从1开始统计，之后利用n-1来向下对齐
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        //注意这个获取某一位数字的操作
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        Offer44FindNthDigit offer44FindNthDigit = new Offer44FindNthDigit();
        System.out.println(offer44FindNthDigit.findNthDigit(3));
        System.out.println(offer44FindNthDigit.findNthDigit(11));

    }

}
