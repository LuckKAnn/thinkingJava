package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 9:42 PM 8/10/2021
 * @email: 1546165200@qq.com
 *
 * 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数
 */

/**
 * 相较于传统的复制链表，这种带随机指针的链表，由于随机指针指向的结点可能还没有被创建，所以不能按照线性的方法去构造
 * 因此，一种方法可以使用哈希表来存储创建的新结点，再来做，但是这样浪费了空间
 * 可以像如下的方法，先利用线性的方法，将新结点接在旧结点的后面，然后再去设置随机指针。
 */
class tNode {
    int val;
    Node next;
    Node random;

    public tNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyRandomList {
//    public tNode copyRandomList(tNode head) {
//        if (head == null) {
//            return null;
//        }
//        for (tNode node = head; node != null; node = node.next.next) {
//            tNode nodeNew = new tNode(node.val);
//            nodeNew.next = node.next;
//            node.next = nodeNew;
//        }
//        for (tNode node = head; node != null; node = node.next.next) {
//            tNode nodeNew = node.next;
//            nodeNew.random = (node.random != null) ? node.random.next : null;
//        }
//        tNode headNew = head.next;
//        for (tNode node = head; node != null; node = node.next) {
//            tNode nodeNew = node.next;
//            node.next = node.next.next;
//            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
//        }
//        return headNew;
//    }

}
