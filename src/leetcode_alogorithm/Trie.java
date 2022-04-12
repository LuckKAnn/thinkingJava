package leetcode_alogorithm;

/**
 * @FileName: Trie
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/8 10:03
 */

import java.util.*;

/**
 *
 * 字典上trie的实现:
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 ***************************************
 * 核心在于，只有一个头结点，也就是使用的地方声明的Trie。之后调用方法传入this即可。
 * 用Trie数组存储子结点，总计26个
 **************************************字典树的应用
 *字典树在串的快速检索中的应用、字典树在“串”排序方面的应用、字典树在最长公共前缀问题的应用
 *
 */
public class Trie {

    private Trie[] children;
    //叶结点判断标志
    private boolean isEnd;
    //字典树从根到叶结点的字符构成的字符串
    private String str;

    public Trie() {
        //26个字母，每个子节点都是一个Tire对象
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * 向前缀树中插入字符串 word
     * 时间复杂度: O(word.length)
     * @param word
     */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            //计算字母索引序号
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
        node.str = word;
    }

    /**
     * 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
     * 相比于startsWith，search还需要满足达到根节点
     * 时间复杂度: O(word.length)
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        //存在字符串word当前仅当存在前缀，且前缀的最后一个结点是叶结点
        return node != null && node.isEnd;
    }

    /**
     * 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     * 时间复杂度: O(prefix.length)
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 这一步的封装是为了两个函数的共用，降低重复代码
     * 时间复杂度: O(prefix.length)
     * @param prefix
     * @return
     */
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
    public boolean thisSearch(String word,int start){
        Trie node = this;
        int i = start;
        int times = 1;
        while (i<word.length()){

            char ch = word.charAt(i);
            int index = ch - 'a';
            node = node.children[index];
            if(node==null) return false;
            if (node.isEnd){
                if(thisSearch(word,i+1)) return true;
            }

            i++;

        }
        return false;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hella");
        trie.insert("hellb");
        System.out.println(trie.search("helloa"));;
        System.out.println(trie.search("hellb"));;
        System.out.println(trie.startsWith("hell"));
    }
}
