package leetcode_alogorithm;

/**
 * @FileName: LexicalOrder386
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 9:27
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 */
public class LexicalOrder386 {

    public static List<Integer> lexicalOrder(int n) {
         List<Integer> list = new ArrayList<>();
        int target = 1;

        while (list.size()!=n){
            list.add(target);
            int lastBit = target%10;
            if (target*10<=n) target*=10;
            else if (lastBit==9){
                target/=10;
                target++;
            }
            else if (target<n){
                target+=1;
            }
            else {
                target/=10;
                target++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(LexicalOrder386.lexicalOrder(130).toArray()));
    }
}
