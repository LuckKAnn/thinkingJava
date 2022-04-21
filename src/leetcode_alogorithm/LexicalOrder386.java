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

    /**
     * 方法一，利用迭代的方式
     * @param n
     * @return
     */
    public static  List<Integer> lexicalOrder01(int n) {
        List<Integer> ans = new ArrayList<>();
        //添加元素至多N次
        //这里不用while(ans.size())可以节约时间
        for (int i = 0, j = 1; i < n; i++) {
            ans.add(j);
            if (j * 10 <= n) {
                j *= 10;
            } else {
                //多了就得除，否则可以加
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return ans;
    }

    /**
     * 递归的方式来做
     * 以树的方式来思考，树不断地向下延展。
     * @param n
     * @return
     */
    private  static final List<Integer> ians = new ArrayList<>();
    private  static final int []arr = {0,1,2,3,4,5,6,7,8,9};
    public static  List<Integer> lexicalOrderIteration(int n) {
        for (int i = 1; i < arr.length; i++) {
            dfs(i,n);
        }
        return ians;
    }

    public  static  void  dfs(int tmp,int n ){
        if (tmp>n) return;
        ians.add(tmp);
        for (int i = 0; i < arr.length; i++) {
            dfs(tmp*10+i,n);
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(LexicalOrder386.lexicalOrder01(130).toArray()));
        System.out.println(Arrays.toString(LexicalOrder386.lexicalOrderIteration(2).toArray()));
    }
}
