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
public class ReorderList26 {

    private static  class ListNode{
        int val;
       ListNode next;
        ListNode(){}
        ListNode(int val) { this.val  = val;}
    }

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode tmp = head;
        while (tmp!=null){
            deque.addLast(tmp);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp!=deque.peekLast()){
            System.out.println(tmp.val);
            ListNode tmpNext = tmp.next;
            ListNode lst = deque.pollLast();
            tmp.next = lst;
            lst.next = tmpNext;
            if (lst==tmpNext) break;
            tmp =tmpNext;
        }
        tmp.next = null;
    }
}
