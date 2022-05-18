package hots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @FileName: ConvertBST538
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 10:36
 */
public class ConvertBST538 {
    private static class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 第一种做法:两次遍历
     * @param root
     * @return
     */

    private List<Integer> list = new ArrayList<>();
    private static final int STRATYGE_TRAVERSE = 1;
    private static final int STRATYGE_FUZHI = 2;
    private int index = 0;
    public TreeNode convertBST(TreeNode root) {
       dfs(root,STRATYGE_TRAVERSE);
        Collections.reverse(list);
        for (int i = 1; i < list.size(); i++) {
            list.set(i,list.get(i)+list.get(i-1));
        }
        Collections.reverse(list);
        dfs(root,STRATYGE_FUZHI);
        return root;

    }

    public void  dfs(TreeNode root,int strategy){
        if (root==null) return;

    //    正向中序遍历
        dfs(root.left,strategy);
        if (strategy==STRATYGE_TRAVERSE){
            list.add(root.val);
        }
        else if(strategy==STRATYGE_FUZHI){
            root.val = list.get(index++);
        }
        dfs(root.right,strategy);

    }


    /**
     * 方法二，能不能就进行一次遍历
     * @param root
     * @return
     */
    public TreeNode convertBST02(TreeNode root) {
        dfs02(root,0);
        return root;
    }

    /**
     * 以右中左的顺序去遍历
     * @param root
     * @param val
     */
    public int  dfs02(TreeNode root,int val ){
        if (root==null) return val;
        int right  = dfs02(root.right, val);
        //    访问中间的结点
        val = right;
        val+= root.val;
        root.val = val;

        int left = dfs02(root.left,val);
        return left;

    }
}
