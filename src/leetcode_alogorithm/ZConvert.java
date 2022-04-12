package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LuckKAnn
 * @date : 18:13 2021/9/10
 * @email: 1546165200@qq.com
 */

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 */
public class ZConvert {
    /**
     * 本题无需把数组声明出来并一步步的填空，直接通过观察指针的运行方式，分行进行存储，很快就能解决
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows==1) return s;

        boolean flag =false;
        List<StringBuilder> l = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++) l.add(new StringBuilder());
        int currentRow = 0;

        for(int i=0;i<s.length();i++){
            l.get(currentRow).append(s.charAt(i));
            if(currentRow==0||currentRow==numRows-1) flag = !flag;
            currentRow += flag==true?1:-1;
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb : l ){
            ans.append(sb.toString());
        }

        return ans.toString();


    }
}
