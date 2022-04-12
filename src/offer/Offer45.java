package offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @FileName: Offer45
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 9:36
 */
public class Offer45 {

    /**
     * 解题思路: 此题求拼接起来的最小数字，本质上是一个排序问题。设数组 numsnums 中任意两数字的字符串为 xx 和 yy ，则规定 排序判断规则 为：
     *
     * 若拼接字符串 x + y > y + xx+y>y+x ，则 xx “大于” yy ；
     * 反之，若 x + y < y + xx+y<y+x ，则 xx “小于” yy ；
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num :nums){
            list.add(String.valueOf(num));
        }

        Collections.sort(list,(o1,o2)->(o1+o2).compareTo(o2+o1));

        StringBuilder sb = new StringBuilder();
        for (String s :list){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Offer45 offer45 = new Offer45();
        System.out.println(offer45.minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
