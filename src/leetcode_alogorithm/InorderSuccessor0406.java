package leetcode_alogorithm;


/**
 * @FileName: InorderSuccessor0406
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/16 10:28
 */
public class InorderSuccessor0406 {

    /**
     * 是否就是一种中序遍历的非递归方式呢？
     * 如果就用递归呢？
     * @param root
     * @param p
     * @return
     */

    public TreeNode lstVist = null;
    public TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        dfs(root,p);
        return ans;
    }


    public void dfs(TreeNode root, TreeNode p){
        if (root==null||ans!=null) return;
        dfs(root.left,p);
        if (lstVist==p){
            ans = root;
        }
        //    否则访问这个节点
        lstVist = root;
        dfs(root.right,p);
    }


    /**
     * 非递归，利用二叉搜索树的特性
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor01(TreeNode root, TreeNode p) {
        //如果P结点的右子树存在，那么就为右边的最左元素
        TreeNode successor = null;
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        //如果P结点的右子树不存在，那么要从根节点开始找其父节点
        TreeNode node = root;
        while (node != null) {
            //根据二叉搜索树的特性来移动
            //P结点的父节点一定是小于等于它的，而后一个结点一定是大于等于P的

            //如果大于了，那么有可能，或者还要继续压缩
            if (node.val > p.val) {
                successor = node;
                node = node.left;
            } else {
                //如果小于了，不可能，往大的方向走
                node = node.right;
            }
        }
        return successor;
    }

}
