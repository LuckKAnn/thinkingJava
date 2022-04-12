package hots;

/**
 * @FileName: MinDistance72
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 20:06
 */
public class MinDistance72 {
    /**
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    /**
     * 非动态规划的做法
     *
     * 这样的做法易于理解，思想简单
     */
    int min = Integer.MAX_VALUE;
    int [][]cache;
    public int minDistance(String word1, String word2) {
        //重在这个二维缓存，缓存的信息同时和i和j都相关
        min = Math.min(dfs(word1,word2,0,0),min);
        cache = new int[word1.length()][word2.length()];
        return min;

    }

    public int dfs(String s,String d ,int i,int j){
        if (cache[i][j]!=0) return cache[i][j];
        if (j==d.length()&&i==s.length()) return 0;
        //为什么是d.length()-j，因为这个i，j表征的位置并没有被使用，而只是当前到它了，所以他也要考虑进去
        if(i==s.length()){
            return d.length()-j;
        }
        if(j==d.length()){
            return s.length()-i;
        }


        if(s.charAt(i)==d.charAt(j)){
            return dfs(s,d,i+1,j+1);
        }
        //各种情况都去测试一下
        //插入
        int insert = dfs(s,d,i,j+1)+1;

        //删除
        int delete = dfs(s,d,i+1,j)+1;
        //替换
        int replace = dfs(s,d,i+1,j+1)+1;
        int min = Math.min(insert,Math.min(delete,replace));
        cache[i][j] = min;
        return  min;

    }

    public static void main(String[] args) {
        String str = "horse";
        String str2 = "ros";
        MinDistance72 minDistance72 = new MinDistance72();
        System.out.println(minDistance72.minDistance(str,str2));
    }
}
