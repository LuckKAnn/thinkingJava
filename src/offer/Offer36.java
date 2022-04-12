package offer;

/**
 * @FileName: Offer36
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 19:11
 */

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Offer36 {

    private static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }



    Node pre ,head;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;

        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;

    }

    /**
     * 谨记左中右的遍历顺序
     * 然后用一个指针记录前一个指针是什么，再进行改变即可。
     * @param root
     */
    public void dfs(Node root){
        if(root==null) return;
        dfs(root.left);

        if(pre!=null){
            pre.right = root;
            root.left = pre;
        }
        else{
            head = root;
        }
        pre = root;

        dfs(root.right);
    }

}
