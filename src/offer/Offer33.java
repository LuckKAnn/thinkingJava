package offer;

/**
 * @FileName: Offer33
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 20:04
 */

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Offer33 {
    boolean flag = true;

    /**
     * 核心在于，对于二叉搜索树的后序遍历序列，其前面
     * 会分成两部分
     * 一部分大于最后一个结点，一部分小于最后一个结点
     * @param p
     * @return
     */
    public boolean verifyPostorder(int[] p) {

        if(p==null||p.length==0) return true;
        dfs(p,0,p.length-1);
        return flag;
    }

    public void dfs(int []p,int s,int e ){
        if(!flag) return;
        if(s==e||e<s) return;
        int end = p[e];
        int big = -1;
        int small  = -1;
        for(int i=e-1;i>=s;i--){
            if(p[i]>end) big = i;
            else small = i;

            if(small>big&&big!=-1) flag = false;

        }

        if(big!=-1) {
            dfs(p,s,big-1);
            dfs(p,big,e-1);
        }
        else dfs(p,s,e-1);


    }

}
