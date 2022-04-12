package leetcode_alogorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @FileName: CanReach1306
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 19:33
 */
public class CanReach1306 {
    /**
     * 核心思路:做广度优先搜索
     * 要注意，做BFS的时候，可以用队列来进行信息存储，而不一定需要用递归(递归算是DFS了吧)
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        //防止进入死循环
        //用数组来存储visit情况，而非使用Set
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            //两个方向
            int left = tmp - arr[tmp],right = tmp + arr[tmp];
            if(left >= 0){
                if(arr[left] == 0) return true;
                if(!visited[left]){
                    visited[left] = true;
                    queue.add(left);
                }
            }
            if(right < n){
                if(arr[right] == 0) return true;
                if(!visited[right]){
                    visited[right] = true;
                    queue.add(right);
                }
            }
        }
        return false;
    }


}
