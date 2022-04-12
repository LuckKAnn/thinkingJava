package leetcode_alogorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: MapSum
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/11/14 14:12
 */
public class MapSum {
    Map<String,Integer> mp ;
    public MapSum() {
        mp  =new HashMap<>();
    }

    public void insert(String key, int val) {
        mp.put(key,val);
    }

    public int sum(String prefix) {
        int sum= 0;
        for (Map.Entry<String,Integer> entry:mp.entrySet()){
            String key = entry.getKey();
            if (key.startsWith(prefix)) sum+=entry.getValue();
        }
        return sum;
    }

}
