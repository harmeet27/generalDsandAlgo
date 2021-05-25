package com.preparation.ds.array.matrix;

/**
 * Algo with extra space
 * <p>
 * for(int i=0;i<arr.length;i++){
 *      for(int j=0;j<arr.length;j++)
 *          sol[j][arr.length-1-i]=arr[i][j];
 * <p>
 * <p>
 * <p>
 * <p>
 * Constraint : Without space --> Further algo
 * <p>
 * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
 * <p>
 * 1  2  3
 * 4  5  6
 * 7  8  9
 * after transpose, it will be swap(matrix[i][j], matrix[j][i])
 * <p>
 * 1  4  7
 * 2  5  8
 * 3  6  9
 * Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j]) i.e. flip the row by column
 * <p>
 * 7  4  1
 * 8  5  2
 * 9  6  3
 * Hope this helps.
 * <p>
 * For Anticlockwise rotation,transpose step would remain the same.In the last step instead of flipping the columns,
 * flip the rows vertically.
 **/
public class RotatMatrixBy90 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}

