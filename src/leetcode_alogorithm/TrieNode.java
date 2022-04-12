package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 22:41 2021/9/2
 * @email: 1546165200@qq.com
 */

/**
 * 一种前缀树的实现方式，
 * word存储的是到叶结点为止的字符串
 * children 存储的是该结点的下一个字符结点
 */
public class TrieNode {
    TrieNode[] children;
    String word;
    TrieNode() {
        children = new TrieNode[26];
    }

}
