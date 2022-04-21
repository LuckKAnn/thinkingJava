package hots;

import java.util.List;

/**
 * @FileName: OddEvenList328
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 10:44
 */
public class OddEvenList328 {
    private static  class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) { this.val  = val;}
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode tmp = head;
        int odd = 0;
        int even = 0;
        while (tmp!=null){
            if ((tmp.val&1)==0) odd++;
            else even++;
            tmp = tmp.next;
        }

        ListNode fast = tmp;
        for (int i = 0; i < even; i++) {
            fast = fast.next;
        }
        tmp = head;

        while (fast!=null){

        }






        return null;

    }

    /**
     * 328. 奇偶链表
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     *
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     *
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     *
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     *
     *
     * 这里并不是根据里面的数字是奇数还是偶数来排序，而是根据索引序号
     * @param head
     * @return
     */
    /**
     * 由于交换的情况都是一样的，可以直接迭代的去实现。
     * @param head
     * @return
     */
    public ListNode oddEvenListByIndex(ListNode head) {
        if (head==null) return null;
        ListNode tmp = head;
        ListNode pre = null;
        ListNode evenHead = null;
        ListNode eventmp = null;
        int count = 1;

        while (tmp!=null){
            if ((count&1)==1){
                pre = tmp;
                tmp = tmp.next;
            }
            else{
                //偶数
                /**
                 * 核心在于，要进行断链，前面要断，后面要断，后面还需要进行一下记录
                 */
                pre.next = tmp.next;
                tmp.next = null;
                if (evenHead==null){
                    evenHead = tmp;
                    eventmp = evenHead;
                }
                else{
                    eventmp.next = tmp;
                    eventmp = eventmp.next;
                }
                tmp =pre.next;

            }
            count++;
        }

        pre.next = evenHead;

        return head;
    }




    public ListNode oddEvenLists(ListNode head) {
        ListNode tmp = head;
       ListNode oddHead = null;
       ListNode pre = null;
       ListNode evenHead = null;
       ListNode eventmp = null;
       while (tmp!=null){
           if ((tmp.val&1)==1){
           //   奇数
               if (oddHead==null){
                   oddHead = tmp;
               }

               pre = tmp;
               tmp = tmp.next;
           }
           else{
               //偶数
               pre.next = tmp.next;
               tmp.next = null;
               if (evenHead==null){
                   evenHead = tmp;
                   eventmp = evenHead;
               }
               else{
                   eventmp.next = tmp;
                   eventmp = eventmp.next;
               }
               tmp =pre.next;

           }
       }

       pre.next = evenHead;

       return oddHead;
    }

    /**
     * 官方写法
     * @param head
     * @return
     */
    public ListNode oddEvenListOffice(ListNode head) {
        if (head == null) {
            return head;
        }

        //这种方式能够利用更少的指针，思路也更加的清晰
        //直接仅仅利用两个位置，断链自然地生成
        //odd利用首部，even利用首部的下一个
        //每一次循环可以给odd.next和even.next都设置一个数
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            //注意要先odd再even
            //因为odd更新之后，odd就是原来even的下一个，再用odd.next就能拿到那个指针
            //
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //这里也挺关键，不仅仅是为了满足题目的条件
        //其实更是为了将最后odd的指针改变，否则其可能和even指向同一个
        odd.next = evenHead;
        return head;
    }

}
