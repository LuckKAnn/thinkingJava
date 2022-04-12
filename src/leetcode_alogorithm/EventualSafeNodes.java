package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LuckKAnn
 * @date : 10:15 PM 8/5/2021
 * @email: 1546165200@qq.com
 *
 */

/**
 * 802. 找到最终的安全状态
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 *
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 *
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 *
 */

/**
 * 这种题的关键，是有向图判断是否有环的算法。
 * 可以通过visit数组，设置三种状态0未被访问 1有环 2安全结点
 * 这是俗称的三色标记法，每当结点被访问，设置为1，若最后又碰到1，则有环，否则为2
 *
 *
 * 重点*******************  三色标记法中，标记结点的状态是有环就行，区别于一些其他的条件，也就是这是定性的
 * 当然本题也可以用逆拓扑排序来做，先把线反过来构造数组，然后开始逐一消去，只要最终得到入度为0的点，都是安全的
 *
 */
public class EventualSafeNodes {
    int [] visit;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ret = new ArrayList<>();
        visit = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(canEnd(graph,i)) {
                ret.add(i);
            }
        }
        return  ret;
    }

    public boolean canEnd(int [][]graph,int index){
        if(visit[index]>0) return  visit[index]==2;
        int len = graph[index].length;
        visit[index]=1;
        for(int k=0;k<len;k++){
            if(!canEnd(graph,graph[index][k])){
                return false;
            }
        }
        visit[index]=2;
        return true;

    }
}
