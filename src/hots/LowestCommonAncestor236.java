package hots;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @FileName: LowestCommonAncestor236
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 11:18
 */
public class LowestCommonAncestor236 {
    private static class TreeNode {
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


    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * 一种就是用hash表存储，还有
     */
    Map<TreeNode,TreeNode> mp;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        mp = new HashMap<>();
        dfs(root,p,q,null);
        Set<TreeNode> set = new HashSet<>();
        while (p!=null){
            set.add(p);
            p = mp.get(p);
        }
        while (q!=null){
            if (set.contains(q)) return q;
            q = mp.get(q);
        }
        return null;
    }

    public  void  dfs(TreeNode root,TreeNode p,TreeNode q,TreeNode father){
        if (root==null) return;
        mp.put(root,father);
        if (root==p||root==q) return;
        else{
            dfs(root.left,p,q,root);
            dfs(root.right,p,q,root);
        }
    }
    //
    //public  boolean dfs(TreeNode root,TreeNode p ,TreeNode q){
    //
    //}


    /**
     * 第二种方式，能否直接利用dfs
     * @param root
     * @param p
     * @param q
     * @return
     */
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {

        dfs02(root,p,q);

        return ans;
    }

    public  boolean  dfs02(TreeNode root,TreeNode p,TreeNode q){
       if (root==null) return false;
       //加上这条语句，就可以让时间效率拉满
       // 这条语句可以去除掉一些多余的判断逻辑，如果说结果已经有了，那再向上判断就没有必要了


       if (ans!=null) return false;
       boolean valLeft = dfs02(root.left,p,q);
       boolean valRight = dfs02(root.right,p,q);
        /**
         * 这里其实基于一个点，就是如果一个点是最近公共祖先，那么其要么左右都为true
         * 要么自己为p/q，而左右其一为true。并且，这样的结点只可能有一个点
         */
        if(((root==p||root==q)&&(valLeft||valRight))||(valLeft&&valRight)){
                ans = root;
                return  true;
        }
        return  root==p||root==q||valLeft||valRight;
    }
}
