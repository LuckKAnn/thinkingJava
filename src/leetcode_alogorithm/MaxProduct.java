package leetcode_alogorithm;
import  java.util.*;
/**
 * @FileName: MaxProduct
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/11/17 10:30
 */

/**
 * 318. 最大单词长度乘积
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 ***************************************************'
 * 此题目限定了字符为小写字符，只有26个字母，这种情况下可以用位掩码的方式
 * 之前认为26位，int类型存储不到，因为我是按照值来看的，但是实际上可以按照位来看
 * int类型32位，完全满足存储，每一个字符用一个二进制位表示即可而不是一个十进制位
 */
public class MaxProduct {

    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int mask = 0;
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                //计算掩码的方式
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                //掩码相与为0，说明没有共同的字符
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }
}
