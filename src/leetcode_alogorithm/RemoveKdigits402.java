package leetcode_alogorithm;

/**
 * @FileName: RemoveKdigits402
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/8 11:31
 */

import java.util.*;

/**
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 * TODO:字节面试题
 */
public class RemoveKdigits402 {

    /**
     * 所谓的单调栈结题
     *
     * 思路就是，对于相同长度的数   xxxixx  xxxjxx
     * 如果i>j，那么xxxixx >xxxjxx 反之亦然
     * 维护一个单调栈，如果前面的数比现在的数更大，那么其就没有存在的必要，完全可以删除
     * 因为是从高位开始剔除的，总是能使得剔除是最有利的，高位的无法剔除，才会走到低位
     * 注意，因为可能存在完全单调的情况，所以应该要进行判断，因为必须要移除K个数字，在这种情况下，找最小的话，就是从后移除，找最大的从前移除
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Character> queue = new LinkedList<>();

        for (char c :num.toCharArray()){
            while (!queue.isEmpty()&&queue.getLast()>(c)&&k>0){
                queue.removeLast();
                k--;
            }
            queue.add(c);
        }

        while (k!=0){
            queue.removeLast();
            k--;
        }

        StringBuilder sb= new StringBuilder();
        //处理前置0
        boolean preZero = true;
        for(char c:queue){
            if (preZero&&c=='0') continue;
            else {
                preZero=false;
                sb.append(c);
            }
        }
        if (queue.isEmpty()||preZero) return "0";
        return sb.toString();
    }



    public static void main(String[] args) {

        RemoveKdigits402 removeKdigits402 = new RemoveKdigits402();
        System.out.println(removeKdigits402.removeKdigits("1432219", 3));
        System.out.println(removeKdigits402.removeKdigits("10200", 1));
        System.out.println(removeKdigits402.removeKdigits("10", 2));
        System.out.println(removeKdigits402.removeKdigits("10", 1));
    }
}
