package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : LuckKAnn
 * @date : 9:29 PM 8/10/2021
 * @email: 1546165200@qq.com
 * 1743. 从相邻元素对还原数组
 */

/***
 * 核心: 对于序对，(a,b)，(b,f)等，可以通过使用map接上ArrayList来存储
 */
public class RestoreArray {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer,ArrayList<Integer>> mp = new HashMap<>();
        for(int [] arr:adjacentPairs){
            mp.putIfAbsent(arr[0],new ArrayList<>());
            mp.putIfAbsent(arr[1],new ArrayList<>());
            mp.get(arr[0]).add(arr[1]);
            mp.get(arr[1]).add(arr[0]);
        }
        int []ret = new int[adjacentPairs.length+1];
        for(Map.Entry<Integer,ArrayList<Integer>> entry:mp.entrySet()){
            Integer key = entry.getKey();
            if(entry.getValue().size()==1){
                ret[0] = key;
                break;
            }
        }
        ret[1] = mp.get(ret[0]).get(0);

        for(int i=2;i<=adjacentPairs.length;i++){
            ArrayList<Integer> list = mp.get(ret[i - 1]);
            ret[i] = list.get(0)==ret[i-2]?list.get(1):list.get(0);
        }

        return ret;
    }
}
