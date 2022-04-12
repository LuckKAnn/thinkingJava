package leetcode_alogorithm;

/**
 * @FileName: Flatten
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/22 17:53
 */


/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 **************************************
 * 二叉树的展开，展开为链表。如何原地操作。
 * 注意到前序遍历访问各节点的顺序是根节点、左子树、右子树。如果一个节点的左子节点为空，则该节点不需要进行展开操作。如果一个节点的左子节点不为空，则该节点的左子树中的最后一个节点被访问之后，
 * 该节点的右子节点被访问。该节点的左子树中最后一个被访问的节点是左子树中的最右边的节点，也是该节点的前驱节点。因此，问题转化成寻找当前节点的前驱节点。
 *
 * 具体做法是，对于当前节点，如果其左子节点不为空，则在其左子树中找到最右边的节点，作为前驱节点，
 * 将当前节点的右子节点赋给前驱节点的右子节点，然后将当前节点的左子节点赋给当前节点的右子节点，并将当前节点的左子节点设为空。对当前节点处理结束后，继续处理链表中的下一个节点，直到所有节点都处理结束。
 *
 */
public class Flatten {

    public void flatten(TreeNode root) {
        TreeNode tmp = root;
        while (tmp!=null){
            if (tmp.left==null){
                tmp=tmp.right;
            }
            else {
                TreeNode leastRight = findLeastRight(tmp.left);
                leastRight.right = tmp.right;
                tmp.right = tmp.left;
                tmp.left = null;
                tmp = tmp.right;

            }
        }
    }

    public TreeNode findLeastRight(TreeNode root){

        while (root.left!=null||root.right!=null){
            if (root.right!=null){
                root =root.right;
            }
            else  if (root.left!=null){
                root=root.left;
            }
        }
        return  root;

    }
}
