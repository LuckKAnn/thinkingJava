package hots;

/**
 * @FileName: NumIslands200
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/18 10:02
 */

/**
 * 200. 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 * TODO:热门题目
 * LK 字节跳动原题
 */
public class NumIslands200 {

    int count = -1;
    int m ,n;

    /**
     * 这里其实也可以直接将遍历过的位置复位为0即可
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count--;
                }
            }
        }
        return -(count+1);
    }
    public void dfs(char[][]grid,int i,int j){
        grid[i][j]=-1+'0';

        //如果只管右边和下边,是错的，因为要相连，如果只管下和右，可能会多出来
        if (i-1>=0&&grid[i-1][j]=='1') dfs(grid,i-1,j);
        if (j-1>=0&&grid[i][j-1]=='1') dfs(grid,i,j-1);
        if (i+1<m&&grid[i+1][j]=='1') dfs(grid,i+1,j);
        if (j+1<n&&grid[i][j+1]=='1') dfs(grid,i,j+1);
    }
}
