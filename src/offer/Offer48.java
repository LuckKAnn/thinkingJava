package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: Offer48
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 9:45
 */

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Offer48 {

    /**
     * 注意一点，就是需要暂存左边界的情况，如果出现的重复字段在左边界之外，不作考虑
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int len = 0;
        int ans = 0;
        int left = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int index = map.getOrDefault(c,-1);
            if(index>=left) {
                len-=(index-left);
                left = index+1;
            }
            else len++;
            map.put(c,i); //可以确定每一个都会更新和覆盖
            ans = Math.max(len,ans);
        }
        return ans;
    }
}
