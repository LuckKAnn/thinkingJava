package hots;

/**
 * @FileName: reverseKGroup
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/11 10:06
 */

import javax.swing.tree.TreeNode;
import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {
    private static  class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val  = val;}
        ListNode(int val, ListNode next) { this.val  = val;
        this.next = next;};


    }

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }
}
