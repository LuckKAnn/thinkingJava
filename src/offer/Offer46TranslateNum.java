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
