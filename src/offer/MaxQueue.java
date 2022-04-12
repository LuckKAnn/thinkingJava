package offer;

/**
 * @FileName: MaxQueue
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/29 19:14
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * offer59
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1

 */

public class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    /**
     * 本算法基于问题的一个重要性质：当一个元素进入队列的时候，它前面所有比它小的元素就不会再对答案产生影响。
     *
     * 举个例子，如果我们向队列中插入数字序列 1 1 1 1 2，那么在第一个数字 2 被插入后，数字 2 前面的所有数字 1 将不会对结果产生影响。因为按照队列的取出顺序，数字 2 只能在所有的数字 1 被取出之后才能被取出，因此如果数字 1 如果在队列中，那么数字 2 必然也在队列中，使得数字 1 对结果没有影响。
     *
     * 按照上面的思路，我们可以设计这样的方法：从队列尾部插入元素时，我们可以提前取出队列中所有比这个元素小的元素，使得队列中只保留对结果有影响的数字。这样的方法等价于要求维持队列单调递减，即要保证每个元素的前面都没有比它小的元素。
     *
     * 那么如何高效实现一个始终递减的队列呢？我们只需要在插入每一个元素 value 时，从队列尾部依次取出比当前元素 value 小的元素，直到遇到一个比当前元素大的元素 value' 即可。

     */
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty()&&deque.getLast()<value){
           deque.removeLast();
        }
        deque.add(value);
    }

    public int pop_front() {
        Integer poll = queue.poll();
        if (poll==null) return -1;
        if (deque.peek().equals(poll)){
            deque.poll();
        }
        return poll;


    }
}
