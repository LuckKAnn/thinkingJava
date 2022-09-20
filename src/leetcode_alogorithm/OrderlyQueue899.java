package leetcode_alogorithm;

/**
 * @FileName: OrderlyQueue899
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/8/3 23:16
 */

import java.util.Arrays;

/**
 * 899. 有序队列
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 *
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 * 两个点:一个是当K=1时，最小字典序出现的情况和当K>=2时，最小字典序出现的情况
 */
public class OrderlyQueue899 {

    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smallest = s;
            StringBuilder sb = new StringBuilder(s);
            int n = s.length();
            for (int i = 1; i < n; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                // 用这种方式，能够最大限度的降低排序的消耗，也能降低空间消耗
                // 比用subString的方式好
                if (sb.toString().compareTo(smallest) < 0) {
                    smallest = sb.toString();
                }
            }
            return smallest;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }
}
