package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 22:40 2021/9/2
 * @email: 1546165200@qq.com
 */

import java.util.List;

/**
 *
 * 前缀树，字典树的用法
 * 前缀树的性质参照: https://blog.csdn.net/u013309870/article/details/71081393
 *
 *
 */

/**
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 */
public class ReplaceWords {
    public String replaceWords(List<String> roots, String sentence) {
        TrieNode trie = new TrieNode();
        for (String root : roots) {
            TrieNode cur = trie;
           // 将字符串变成字符数组
            for (char letter : root.toCharArray()) {
               // 如果该结点的子结点中没有该字符，则创建，否则不创建
                if (cur.children[letter - 'a'] == null)
                    cur.children[letter - 'a'] = new TrieNode();
                cur = cur.children[letter - 'a'];
            }
           // 最后一个字符存储完整字符串
            cur.word = root;
        }

        StringBuilder ans = new StringBuilder();

        /**
         * 注意，\\s+可以匹配空格，制表符等空格。
         * [\s]表示，只要出现空白就匹配
         * [\S]表示，非空白就匹配
         */
        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0)
                ans.append(" ");

            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                if (cur.children[letter - 'a'] == null || cur.word != null)
                    break;
                cur = cur.children[letter - 'a'];
            }
            ans.append(cur.word != null ? cur.word : word);
        }
        return ans.toString();
    }
}
