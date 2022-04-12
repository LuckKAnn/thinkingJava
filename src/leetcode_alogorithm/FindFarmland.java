package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LuckKAnn
 * @date : 13:42 2021/9/5
 * @email: 1546165200@qq.com
 */

/**
 * 周赛 5847. 找到所有的农场组
 * 给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
 *
 * 为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，也就是说一个农场组中的任何一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。
 *
 * land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角的坐标。一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。
 *
 * 请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。可以以 任意顺序 返回所有农场组。
 *
 * ********这是一个在图中找矩形的问题
 */
public class FindFarmland {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList();
        int m = land.length, n = land[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(land[i][j] == 0){
                    continue;
                }

                int row = i, col = j;
                // 向下探索矩形农场组行
                while(row + 1 < m && land[row+1][j] == 1) row++;
                // 向右探索矩形农场组的列
                while(col + 1 < n && land[i][col+1] == 1) col++;

                res.add(new int[]{i,j, row, col});

                // 探索到的矩形农场组中所有块置为0，避免后续的遍历
                for(int x = i; x <= row; x++){
                    for(int y = j; y <= col; y++){
                        land[x][y] = 0;
                    }
                }
            }
        }
        //记住这个用法，list转array
        //这里可以直接传入一个小的数组，其方法会自动创建新的大数组
        return res.toArray(new int[0][0]);

    }

}
