package hots;

import java.util.*;

/**
 * @FileName: GroupAnagrams46
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 10:27
 */

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *

 */
public class GroupAnagrams49 {

    /**
     * 字母异位词分组
     * 这道题可以看看这种简洁的方式。
     * 思路还是很简单，就是利用字符串的排序以及Map来进行分类
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //Set<>
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> mp = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> orDefault = mp.getOrDefault(s, new ArrayList<>());
            orDefault.add(str);
            mp.put(s,orDefault);
        }
        return new ArrayList<List<String>>(mp.values());

    }
}
