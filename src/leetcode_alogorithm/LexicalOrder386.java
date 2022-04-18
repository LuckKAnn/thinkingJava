package leetcode_alogorithm;

/**
 * @FileName: LexicalOrder386
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 9:27
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 */
public class LexicalOrder386 {

    public List<Integer> lexicalOrder(int n) {
         List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list,(o1,o2)->{
            return String.valueOf(o1).compareTo(String.valueOf(o2));
        });

        return list;
    }
}
