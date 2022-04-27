package hots;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {

    private LinkedHashMap<Integer,Integer> datas = new LinkedHashMap<>();
    int free = 0;
    public LRUCache(int capacity) {
        free = capacity;
    }

    public int get(int key) {

        if (datas.containsKey(key)){
            int val = datas.get(key);
            datas.remove(key);
            datas.put(key,val);
            return  val;
        }
        else  return -1;
    }

    public void put(int key, int value) {

        if (datas.containsKey(key)){
            datas.remove(key);
            datas.put(key,value);
        }
        else{
            if (free==0){
//            如果没有空闲的空间，应该删除某尾的元素
                Set<Integer> integers = datas.keySet();
                int endKey = -1;
                for (int k :integers){
                    endKey=k;
                    break;
                }
                datas.remove(endKey);
                free++;
            }
            datas.put(key,value);
            free--;

        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
       lruCache.put(2,6);
       lruCache.put(1,5);
       lruCache.put(1,2);
       lruCache.get(1);
       lruCache.get(2);
    }
}
