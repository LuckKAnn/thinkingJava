package offer2;

import hots.OddEvenList328;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: ReorderList26
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/21 9:39
 */

/**
 * 剑指 Offer II 026. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 *  L0 → L1 → … → Ln-1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList26 {

    private static  class ListNode{
        int val;
       ListNode next;
        ListNode(){}
        ListNode(int val) { this.val  = val;}
    }

    /**
     * 这道题的关键是，最后的结尾的处理，结尾的判断条件
     * @param head
     */
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode tmp = head;
        while (tmp!=null){
            deque.addLast(tmp);
            tmp = tmp.next;
        }

        tmp = head;
        boolean flag = false;
        /**
         * tmp!=deque.peekLast()解决奇数个结点的情况
         */
        while (tmp!=deque.peekLast()){
            ListNode tmpNext = tmp.next;
            ListNode lst = deque.pollLast();
            /**
             * 解决的是偶数个结点结尾的情况
             */
            if(tmpNext ==lst){
                flag = true;
                lst.next=null;
                break;
            }
            tmp.next = lst;
            lst.next = tmpNext;
            tmp =tmpNext;
        }
        //如果是奇数个结点，需要单独处理最后一个结点的下一个结点为null，而偶数个结点的情况在上面以及处理了
        if (!flag) tmp.next = null;
     //   if(tmp!=null) tmp.next = null;
    }
}
