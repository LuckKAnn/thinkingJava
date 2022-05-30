package hots;

import offer.Offer07;

import java.util.List;

/**
 * @FileName: DetectCycle142
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/12 11:35
 */

/**
 * 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * TODO:怎么推导的
 *
 *
 */
public class DetectCycle142 {
    private static  class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val  = val;}


    }


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (slow!=fast){
            slow = slow.next;
            fast = fast.next.next;
        }

        //注意，之后就是一步一步的走了
        slow = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }


    /**
     * 官方答案
     * @param head
     * @return
     */
    public ListNode detectCycleOffice(ListNode head) {
        //先判断null
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            //当下fast.next为null
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
