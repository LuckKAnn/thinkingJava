package offer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @FileName: SortList77
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/21 9:54
 */

/**
 * LK:这道利用归并排序处理链表的问题很不错
 */
public class SortList77 {
    private static  class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val  = val;}
        ListNode(int val,ListNode next) { this.val  = val;
        this.next = next;}
    }

    /**
     * 利用选择排序来做,选择排序的时间复杂度是On2，导致可能超时
     * @param head
     * @return
     */
    public ListNode sortListSelectionSort(ListNode head) {

        ListNode pre=null ;
        ListNode tmp = head;
        ListNode hair = new ListNode(Integer.MIN_VALUE);
        //hair.next = head;

        while (tmp!=null){
            ListNode traverse =  hair.next;
            ListNode tmpNext = tmp.next;
            pre = hair;
          do {
              if (traverse==null){
                  pre.next = tmp;
                  tmp.next = null;
                  break;
              }
              else if (traverse.val>tmp.val){
                   pre.next = tmp;
                   tmp.next = traverse;
                   break;
              }
            pre = traverse;
            traverse = traverse.next;
            }  while (traverse!=null);

            tmp = tmpNext;
        }

        return hair.next;
    }

    /**
     * 官方解法，利用自底向上的归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        /**
         * 归并排序的次数
         * 先是1个1组，每2个进行归并，然后是2个一组，每2个进行归并
         * 第一次完成22有序，第二次44有序，最后全部有序
         */
        for (int subLength = 1; subLength < length; subLength <<= 1) {

            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                //每次找到相邻的两组
                ListNode head1 = curr;
                //这里是确定了第一组的范围？
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                //这是为了断链
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                //找到第二组
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                //这是为了断链，同时记录下下一组的开始位置
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                //两组进行归并
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                //继续下一组
                curr = next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 也就是归并排序的一般写法
     * @param head1
     * @param head2
     * @return
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        //归并
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        //这里是在重新链接回去
        return dummyHead.next;
    }

    public static void main(String[] args) {
        SortList77 sortList77 = new SortList77();
        ListNode l1= new ListNode(-1,new ListNode(5,new ListNode(3,new ListNode(4,new ListNode(0)))));
        sortList77.sortList(l1);
    }
}
