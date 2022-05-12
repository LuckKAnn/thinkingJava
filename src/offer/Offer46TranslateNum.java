package offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @FileName: Offer46TranslateNum
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/6 16:53
 */

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 *
 *
 *
 *
 * 这道题还有解法就是通过用DP，因为这里的，位I具有的不同翻译方法的个数，与I-1相关，I-2相关
 * 如果I-1和I构不成10-25，也就是说，I-1和I不能组合，那么I的翻译方法数就同I-1
 * 如果能构成，那么I的翻译方法数就等于I-1+I-2的数目，因为要么还是选择不合并翻译，为I-1，要么选择合并翻译，为I-2
 */
public class Offer46TranslateNum {

    int ans = 0;
    public int translateNum(int num) {
        List<Integer> list = new ArrayList<>();
        int tmp = 0;
        while(num!=0){
            tmp  = num%10;
            list.add(tmp);
            num/=10;
        }

        Collections.reverse(list);

        dfs(list,0);

        return ans;
    }

    public void dfs( List<Integer> num,int i){
        if (i>=num.size()){
            ans++;
            return;
        };
        int tmp = 0;
        if (i!=num.size()-1&&num.get(i)!=0){
            tmp = num.get(i)*10+num.get(i+1);
            if (tmp<=25){
                dfs(num,i+2);
            }
        }
        dfs(num,i+1);
    }

    public static void main(String[] args) {
        Offer46TranslateNum offer46TranslateNum = new Offer46TranslateNum();
        System.out.println(offer46TranslateNum.translateNum(12258));

    }
}
