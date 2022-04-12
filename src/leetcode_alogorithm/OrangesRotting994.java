package leetcode_alogorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: OrangesRotting994
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/7 16:34
 */
public class OrangesRotting994 {
    private static class  Node{
        int x;
        int y;

        Node(){};
        Node(int _x,int _y){
            this.x = _x;
            this.y = _y;
        }
    }
    Set<Node> set = new HashSet<>();

    /**
     * 核心在于用多源的广度优先搜索
     * @param grid
     * @return
     */
    public int orangesRotting(int [][]grid){
        int goodOrganges = 0;
        int time = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1) goodOrganges++;
                else if(grid[i][j]==2){
                    set.add(new Node(i,j));
                }
            }
        }
        if (goodOrganges==0) return 0;
        //用一个集合去存储
        while (!set.isEmpty()){
            time++;
            Set<Node>tmp = new HashSet<>();
            for(Node n : set){
                if (n.x>0&&grid[n.x-1][n.y]==1){
                    grid[n.x-1][n.y]=2;
                    goodOrganges--;
                    tmp.add(new Node(n.x-1,n.y));
                }
                if (n.x<grid.length-1&&grid[n.x+1][n.y]==1){
                    grid[n.x+1][n.y]=2;
                    goodOrganges--;
                    tmp.add(new Node(n.x+1,n.y));
                }
                if (n.y<grid[0].length-1&&grid[n.x][n.y+1]==1){
                    grid[n.x][n.y+1]=2;
                    goodOrganges--;
                    tmp.add(new Node(n.x,n.y+1));
                }
                if (n.y>0&&grid[n.x][n.y-1]==1){
                    grid[n.x][n.y-1]=2;
                    goodOrganges--;
                    tmp.add(new Node(n.x,n.y-1));
                }
            }
            set = tmp;
        }
       if (goodOrganges==0)return time-1;
       else return  -1;

    }
}
