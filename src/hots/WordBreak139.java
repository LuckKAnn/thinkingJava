package hots;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @FileName: WordBreak139
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/11 11:10
 */
public class WordBreak139 {
    Set<String > set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //注意这里即可。
        if(s==null||s.length()==0) return true;
        if (set.contains(s)) return false;
        /**
         * 这里看一些这种写法，其简洁的特性。
         */
        for (int i = 0; i < s.length(); i++) {
            String pre = s.substring(0,i+1);
            String tail = s.substring(i+1);
            if (wordDict.contains(pre)&&wordBreak(tail,wordDict)){
                return   true;
            }
        }
        //优化点就是增加一个set，如果当前字符串怎么切割都得不到结果，那么之后就不需要再重试
        set.add(s);
        return false;
    }

    public static void main(String[] args) {
        String test = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        WordBreak139 wordBreak = new WordBreak139();
        wordBreak.wordBreak(test,list);
    }
}
