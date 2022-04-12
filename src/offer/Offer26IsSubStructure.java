package offer;


/**
 * @FileName: Offer26IsSubStructure
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 9:30
 */

public class Offer26IsSubStructure {
  private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 这样写的方式能够更加的简洁
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return  ((A!=null&&B!=null)&&(dfs(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B)));
    }


    public boolean dfs(TreeNode A,TreeNode B){
        /**
         * 只要B为null，就正确，如果A为null或者两者不相等，则为false
         */
        if(B==null) return true;
        else if(A==null||A.val!=B.val) return false;
        return dfs(A.left,B.left)&&dfs(A.right,B.right);
    }

}
