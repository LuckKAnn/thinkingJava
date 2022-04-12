package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName: TopVotedCandidate
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/12/11 13:30
 */
class info{
    int time;
    Map<Integer,Integer> mp = new HashMap<>();

    info(int t, Map<Integer,Integer>m){
        time = t;
        mp  = m;
    }
}
public class TopVotedCandidate {

    int [] ans ;
    int []time;
    public TopVotedCandidate(int[] persons, int[] times) {
        
        ans = new int[times.length];
        time= times;
        Map<Integer,Integer> mp = new HashMap<>();
        int max = 0;
        int maxNum=-1;
        for (int i = 0; i < persons.length; i++) {
            mp.put(persons[i],mp.getOrDefault(persons[i],0)+1);
            Integer integer = mp.get(persons[i]);
            if (integer>max){
                ans[i]=persons[i];
                maxNum = persons[i];
            }
            else ans[i]=maxNum;

        }
    }

    public int q(int t) {
       int  i = binarySearch(time,t);
        if (i==time.length) return  ans[time.length-1];

        if (time[i]==t) return  ans[i];
        else  return  ans[i-1];
    }

    public int binarySearch(int []arr,int num){
        int low = 0,high = arr.length-1;
        while (low<=high){
            int mid  = low+(high-low)/2;
            if (arr[mid]==num) return mid;
            else if(arr[mid]<num){
                low  = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return  low;
    }

    public static void main(String[] args) {
        int []arr ={0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(arr,arr);
        int i = topVotedCandidate.binarySearch(arr, 3);
        System.out.println(i);
    }

}
