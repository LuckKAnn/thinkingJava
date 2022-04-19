package offer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName: MaxProduct05
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/11 11:20
 */
public class MaxProduct05 {

    private int max = 0;
    Map<Integer, int[]> mp = new HashMap<>();

    public int maxProduct(String[] words) {
        for (int i = 0; i < words.length; i++) {
            int[] tmp = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                tmp[words[i].charAt(j)-'a']++;
            }
            mp.put(i,tmp);
        }

        for (int i = 0; i < words.length; i++) {
           int []tmp = mp.get(i);
            for (int j = i+1; j < words.length; j++) {
                int []t = mp.get(j);
                boolean flag = false;
                for (int k = 0; k < 26; k++) {
                    if (tmp[k]>0&&t[k]>0){
                        flag = true;
                        break;
                    }
                }
                if (!flag){
                    max = Math.max(words[i].length()*words[j].length(),max);
                }
            }
        }
        return  max;
    }


    /**
     * 通过位掩码来做
     * 这种方法算是比较快的了。注意，有的情况下，能用list实现的功能就不要用map。因为map底层采用链表和红黑树，其建树的时间复杂度挺高的
     * 如果要进行随机访问，那么使用list最合适。
     * @param words
     * @return
     */
    public int maxProduct02(String[] words) {
     List<Integer> list = new ArrayList<>();
        for (String str : words){
            int tmp = 0;
            for (char c :str.toCharArray()){
                tmp|=(1<<(c-'a'));
            }
           list.add(tmp);
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int ma1 = list.get(i);
                int ma2 = list.get(j);
                if ((ma1&ma2)==0)  ans = Math.max(ans,words[i].length()*words[j].length());
            }

        }

        return  ans;
    }
}
