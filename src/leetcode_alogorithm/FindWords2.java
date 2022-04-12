package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : LuckKAnn
 * @date : 19:39 2021/9/16
 * @email: 1546165200@qq.com
 */

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 ****************************************************
 * 思路:
 * 先用Map把所有的首字母位置存储起来。
 * 在利用dfs的方式，逐步去找一个满足条件的方式，能够得到源字符串
 * 但是注意，这里每次走的路径不能重复，那么就要额外设置一个visit数组进行校验
 */
class FindWordsNode{
    int row;
    int col;
    FindWordsNode(int r,int c){
        row = r;
        col = c;
    }
}
public class FindWords2 {
    Map<Character,List<FindWordsNode>> mp = new HashMap<>();
    int m,n;
    boolean [][]visit;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c = board[i][j];
                List<FindWordsNode> list ;
                if(mp.containsKey(c)){
                    list = mp.get(c);
                }
                else list = new ArrayList<>();
                list.add(new FindWordsNode(i,j));
                mp.put(c,list);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for(String word :words){
            List<FindWordsNode>  nodeList= mp.get(word.charAt(0));
            if(nodeList==null) continue;
            for(FindWordsNode node :nodeList){
                visit = new boolean[m][n];
                //只要有一个路径就可以
                if(containsString(board,word,node.row,node.col,0)){
                    ans.add(word);
                    break;
                }
            }
        }

        return ans;

    }

    public boolean  containsString(char [][]board,String str,int i,int j,int index){
        if(board[i][j]!=str.charAt(index)) return false;
        // System.out.println("i:"+i+"\t"+"j:"+j);
        visit[i][j] = true;
        if(index==str.length()-1) return true;
        //只要有一条路走得通
        if(i<m-1&&!visit[i+1][j]&&containsString(board,str,i+1,j,index+1)) return true;
        if(i>0&&!visit[i-1][j]&&containsString(board,str,i-1,j,index+1)) return true;
        if(j<n-1&&!visit[i][j+1]&&containsString(board,str,i,j+1,index+1)) return true;
        if(j>0&&!visit[i][j-1]&&containsString(board,str,i,j-1,index+1)) return true;
        //这里表示如果这条路走不通，那么这条路上所有点的访问都设置为false；
        //因为是dfs所以这里不会出错，但是如果是在BFS的情况下，这就有可能出错
        visit[i][j] =false;
        return false;
    }
}
