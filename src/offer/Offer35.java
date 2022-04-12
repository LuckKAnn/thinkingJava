package offer;

/**
 * @FileName: Offer35
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 9:31
 */

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *

 */
public class Offer35 {
    private static  class  Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 这道题需要注意的点就是，当完成了链表的复制之后，需要将原链表恢复，否则的话就不能算作是拷贝
     *
     * 核心思想: 在每个结点之后创建其拷贝结点，进行指针的设置
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null; //需要注意这些特殊情况
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }

    public static void main(String[] args) {

    }
}
