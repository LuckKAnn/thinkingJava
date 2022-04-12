import java.util.*;

/**
 * @author : LuckKAnn
 * @date : 13:53 2021/6/21
 * @email: 1546165200@qq.com
 */

class TreeNode {
      int val;
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
class Node{
    int x;
    int y;
    TreeNode node;
    Node(int _X,int _Y,TreeNode n)
    {
        x = _X;
        y=_Y;
        node=n;
    }
}


public class algrothim {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Node start = new Node(0,0,root);
        Queue<Node> save = new LinkedList<>();
        Map<Integer,List<Integer>> ans = new TreeMap<>();
        save.add(start);
        while(!save.isEmpty()){
            int len = save.size();
            Map<Integer,List<Integer>> tmpSort = new TreeMap<>();
            for(int i=0;i<len;i++){
                Node poll = save.poll();
                int tmpx =poll.x;
                int tmpy = poll.y;
                TreeNode tmpn = poll.node;
                if(root.left!=null) save.add(new Node(tmpx+1,tmpy-1,root.left));
                if(root.right!=null) save.add(new Node(tmpx+1,tmpy+1,root.right));
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

    public static void main(String[] args) {
        algrothim test = new algrothim();

    }
}
