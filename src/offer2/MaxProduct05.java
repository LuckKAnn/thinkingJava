package offer2;

import java.util.HashMap;
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
}
