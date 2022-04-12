package leetcode_alogorithm;

/**
 * @FileName: DMinDistance
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/1 11:36
 */
public class DMinDistance {
    int[][] cacheLength;
    //这里其实应该算是一种DFS的方式
    //综合考虑了三种情况，每种都去试，然后对结果进行比较和缓存
    public int minDistance(String word1, String word2) {
        if (word1==null||word2==null) {
            return 0;
        }
        //做一个缓存
        cacheLength = new int[word1.length()+1][word2.length()+1];
        return minDistance(word1,word2,0,0);
    }

    public int minDistance(String word1, String word2,int i,int j) {
        //当有一个字符串已经走到末尾了，要变成另一个字符串只能是将另一个字符串剩余字符全部添加过来
        //已经有缓存，说明这一条路已经走过，最优的情况已经知道了
        if (cacheLength[i][j]!=0) {
            return cacheLength[i][j];
        }
        //如果有一方先到达的话，就考虑另一方剩余的长度，都进行删除或者增加即可
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        //不用考虑其他情况，一定是这样最快
        if (word1.charAt(i) == word2.charAt(j)) {//相等就直接向后移动
            return minDistance(word1,word2,i+1,j+1);
        }
        //这一步选择删除，那么就是将word1的当前字符删除
        int deleteLength = minDistance(word1,word2,i+1,j) + 1;
        //这一步选择插入，就是将word2的当前字符插入到word1
        int insertLength = minDistance(word1,word2,i,j+1) + 1;
        //这一步走替换，就是将word2的当前字符替换到word1
        int replaceLength = minDistance(word1,word2,i+1,j+1) + 1;
        //选择上面三种路线中最短的

        int min = Math.min(deleteLength,Math.min(insertLength,replaceLength));
        //int min = deleteLength < insertLength ? deleteLength : insertLength;
        //min = replaceLength < min ? replaceLength : min;
        cacheLength[i][j] = min;
        return min;
    }



}
