package offer;

/**
 * @FileName: Offer38
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/6 19:29
 */

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Offer38 {

    /**
     * 以每一位的视角来看
     * @param s
     * @return
     */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        //似乎转换成字符数组的方式进行交换等的效率要高于Stringbuilder
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        //这里其实是提前定位了一步？
        //如果前面已经确定，那么最后一位已经没有交换的空间，没必要再进行一次
        //TODO:这里很精髓
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }




}
