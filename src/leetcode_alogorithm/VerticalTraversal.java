package leetcode_alogorithm;

/**
 * 二叉树的垂序遍历
 *
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于(row, col)的每个结点而言，其左右子结点分别位于(row + 1, col - 1)和(row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 */
import java.util.*;
/**
 * @author : LuckKAnn
 * @date : 13:53 2021/6/21
 * @email: 1546165200@qq.com
 */

/**
 * 二叉树结点
 */
class TreeNode {
    //结点值
    int val;
    //左右指针
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 坐标序列结点
 * 代表坐标(X，Y)以及其对应的树节点
 */
class Node{
    int x;
    int y;
    TreeNode node;
    Node(int _X, int _Y, TreeNode n)
    {
        x = _X;
        y=_Y;
        node=n;
    }
}


public class VerticalTraversal {
    //存储结果
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Node start = new Node(0,0,root);
        //用来先进行层序遍历
        Queue<Node> save = new LinkedList<>();
        //按照Y坐标进行排列
        Map<Integer,List<Integer>> ans = new TreeMap<>();
        save.add(start);
        while(!save.isEmpty()){
            //层序遍历
            int len = save.size();
            //因为同层内的值要按照大小排列
            Map<Integer,List<Integer>> tmpSort = new TreeMap<>();
            for(int i=0;i<len;i++){
                Node poll = save.poll();
                int tmpx =poll.x;
                int tmpy = poll.y;
                TreeNode tmpn = poll.node;
                if(tmpn.left!=null) save.add(new Node(tmpx+1,tmpy-1,tmpn.left));
                if(tmpn.right!=null) save.add(new Node(tmpx+1,tmpy+1,tmpn.right));
//                若同x同y，则要按照大小排序
                if(tmpSort.containsKey(tmpy)){
                    List<Integer> tmp = tmpSort.get(tmpy);
                    tmp.add(tmpn.val);
                    Collections.sort(tmp);
                    tmpSort.put(tmpy,tmp);
                }
                else{
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(tmpn.val);
                    tmpSort.put(tmpy,tmp);
                }
            }
            //每一轮层序遍历，都要合并一次
            for (Map.Entry<Integer,List<Integer>> entry:tmpSort.entrySet()){
                List<Integer> value = entry.getValue();
                Integer key = entry.getKey();
                if(ans.containsKey(key)){
                    List<Integer> tmp = ans.get(key);
                    tmp.addAll(value);
                    ans.put(key,tmp);
                }
                else{
                    List<Integer> tmp = new ArrayList<>(value);
                    ans.put(key,tmp);
                }
            }

        }
        for (Map.Entry<Integer,List<Integer>> entry:ans.entrySet()){
            List<Integer> value = entry.getValue();
            ret.add(value);
        }
        return  ret;

    }
}
