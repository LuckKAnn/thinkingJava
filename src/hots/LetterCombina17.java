package hots;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: LetterCombina17
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 10:05
 */
public class LetterCombina17 {

   private String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans ;

    /**
     * 这道题就是一道dfs+回溯的问题吧
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits==null||digits.length()==0) return  null;
        dfs(digits,0,new StringBuilder());
        return  ans;
    }

    public  void  dfs(String digits,int index ,StringBuilder sb ){
        if(index==digits.length()){
            ans.add(String.valueOf(sb));
            return;
        }
        int num = digits.charAt(index)-'0';
        String letters = letter_map[num];

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits,index+1,sb);
            //这里进行回溯
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
