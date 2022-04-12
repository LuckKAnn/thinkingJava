package hots;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @FileName: WordBreak
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/11 11:10
 */
public class WordBreak {
    Set<String > set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //注意这里即可。
        if(s==null||s.length()==0) return true;
        if (set.contains(s)) return false;

        for (int i = 0; i < s.length(); i++) {
            String pre = s.substring(0,i+1);
            String tail = s.substring(i+1,s.length());
            if (wordDict.contains(pre)&&wordBreak(tail,wordDict)){
                return   true;
            }
        }
        set.add(s);
        return false;
    }

    public static void main(String[] args) {
        String test = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak(test,list);
    }
}
