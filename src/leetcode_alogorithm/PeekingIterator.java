package leetcode_alogorithm;


import java.util.Iterator;

/**
 * 284. 窥探迭代器
 * 请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
 *
 * 实现 PeekingIterator 类：
 *
 * PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
 * int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 * bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 * int peek() 返回数组中的下一个元素，但 不 移动指针。
 *
 *
 *
 * *************************
 * 这道题，通过分析可以知道，只有next方法会移动迭代器的指针，其他两个方法并不会，所以我们采用一个next来存储下一个元素
 * 注意，原生迭代器调用next方法会导致迭代器指针移动，所以需要找一个变量来存储刚刚移动过的指针
 */
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        next = iter.next();
    }

    public Integer peek() {
        return next;
    }

    @Override
    public Integer next() {
        Integer ans = next;
        next = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

}