package hots;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: DailyTemperatures739
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/12 11:57
 */
public class DailyTemperatures739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int []ans = new int[temperatures.length];

        //利用单调栈来解决每日问题这样的题目
        //需要注意的是Deque/LinkedList的pop和push方法,实现是从对头出入
        Deque<Integer> deque = new LinkedList<>();

        for (int i = temperatures.length-1;i>=0; i--) {
            while (!deque.isEmpty()&&temperatures[deque.getLast()]<=temperatures[i]){
                    deque.removeLast();
            }

            if (deque.isEmpty()){
                ans[i]=0;
            }
            else{
                ans[i] = deque.getLast()-i;
            }
            deque.push(i);

        }

        return ans;

    }

    public static void main(String[] args) {
        DailyTemperatures739 dailyTemperatures739 = new DailyTemperatures739();
        int []arr = {73,74,75,71,69,72,76,73};
        dailyTemperatures739.dailyTemperatures(arr);
    }
}
