package hots;

/**
 * @FileName: Rotate48
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/4/11 9:43
 */
public class Rotate48 {
    /**
     * 先水平翻转，再按照对角线翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = row;
        int tmp ;
    //   水平翻转
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                tmp = matrix[i][j];
                matrix[i][j]=matrix[row-i-1][j];
                matrix[row-i-1][j] = tmp;
            }
        }
    //            按照对角线翻转
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
