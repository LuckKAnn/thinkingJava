package offer;

/**
 * @FileName: Offer07
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/30 9:33
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Offer07 {

      private static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    //  为了方便查找在中序遍历的位置
    Map<Integer,Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) mp.put(inorder[i],i);
        return  doBuildTree(preorder,inorder,0,0,preorder.length-1);

    }

    /**
     *  分治法的思想
     * @param preorder
     * @param inorder
     * @param root     可以用来确定，分界点所在前序遍历序列中的位置
     * @param start     中序遍历序列的开头
     * @param end   中序遍历序列的结尾
     * @return
     */
    public TreeNode doBuildTree(int[] preorder, int[] inorder,int root,int start ,int end) {
        //因为start总是增加的，end总是减少的，如果这样限定，那么start和end都不可能越界
        //这里需要思考的是为什么这个条件同样可以限制root
        if(start>end) return null;
        int iroot = mp.get(preorder[root]);

        TreeNode tmp = new TreeNode(preorder[root]);

        /**
         * 核心在于要注意这里索引位置的计算方式，尤其是第二个root
         * iroot-start是分界点左边有多少个数
         */
        tmp.left = doBuildTree(preorder,inorder,root+1,start,iroot-1);
        tmp.right = doBuildTree(preorder,inorder,root+iroot-start+1,iroot+1,end);

        return tmp;
    }
}
