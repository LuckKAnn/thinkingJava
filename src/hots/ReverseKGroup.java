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
 *
 *
 * TODO:经典题目，字节面试题
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

    /**
     * 非递归的解法，自写
     * 指针较多，需要注意
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode lastEnd = null;
        ListNode nextStart = null;
        ListNode start = null;
        ListNode end = null;
        int count = 0;

        ListNode tmp = head;
        ListNode reverseTmp = null;
        ListNode pre = null;

        while (tmp!=null){
            count++;
            if (count==1){
                start = tmp;

            }
            else if (count==k){
                count=0;
                //开始反转
                end = tmp;
                //需要暂存end的下一个结点，因为之后再取的话就取不到了
                ListNode tmpNext = end.next;
                reverseTmp  = start;
                //终止条件
                while (reverseTmp!=null&&reverseTmp!=tmpNext){
                    ListNode t= reverseTmp.next;
                    reverseTmp.next = pre;
                    pre = reverseTmp;
                    reverseTmp = t;
                }
                //注意这个pre是用在局部翻转的
                //其实这个pre能不能就用来完成局部翻转呢？类似于就是lastEnd
                pre =null;
                nextStart = tmpNext;
                start.next = nextStart;
                if (lastEnd!=null) lastEnd.next = end;
                else head = end;
                lastEnd = start;
                tmp = nextStart;
                continue;
            }
            tmp = tmp.next;

        }

        return head;
    }

    /**
     * 递归的方式完成翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroupDFS(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            //对这一部分进行翻转
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            //也就是将新的头结点和尾结点链接回去
            pre.next = head;
            tail.next = nex;
            //更新新的结点信息
            //pre在这里设置
            //nex在前面进入递归之前进行获取
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    /**
     * 完成局部的翻转之后，返回新的头结点和尾结点
     * @param head
     * @param tail
     * @return
     */
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        //这里是反向进行的翻转？
        //先从头结点链接过去
        //结束条件就是prev结点到达了tail，也就是tail的指针完成了改变
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }


    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        reverseKGroup.reverseKGroup(head,2);
    }
}
