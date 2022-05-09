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
        boolean flag = false;
        while (tmp!=deque.peekLast()){
            ListNode tmpNext = tmp.next;
            ListNode lst = deque.pollLast();
            if(tmpNext ==lst){
                flag = true;
                lst.next=null;
                break;
            }
            tmp.next = lst;
            lst.next = tmpNext;
            tmp =tmpNext;
        }
        if (!flag) tmp.next = null;
     //   if(tmp!=null) tmp.next = null;
    }
}
