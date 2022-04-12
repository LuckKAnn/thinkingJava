package leetcode_alogorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 *
 */
public class PathSum {

    /**
     * 利用前缀和的方式达到O(n)的时间和空间复杂度
     * 关键点在于，需要用map存储之前的前缀和长度
     * 假如某一时刻preSum-targetSum存在，说明有路到当前结点，长度为targetSum。路径数量就等于preSum-targetSum的数量
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    /**
     *
     * @param root
     * @param prefix
     * @param curr
     * @param targetSum
     * @return
     */
    public int dfs(TreeNode root, Map<Integer, Integer> prefix, int curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        //减掉之前加的，因为要回溯了
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}
