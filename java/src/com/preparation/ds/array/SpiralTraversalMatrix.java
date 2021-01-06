package com.preparation.ds.array;

import java.util.LinkedList;
import java.util.List;

public class SpiralTraversalMatrix {

    public static List<Integer> spiralTraverseIteratively(int[][] array) {
        // Write your code here.
        List<Integer> result = new LinkedList();
        int rowStart = 0;
        int rowEnd = array.length - 1;
        int colStart = 0;
        int colEnd = array[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++) {
                result.add(array[rowStart][i]);
            }

            for (int i = rowStart + 1; i <= rowEnd; i++) {
                result.add(array[i][colEnd]);
            }

            for (int i = colEnd - 1; i >= colStart; i--) {
                //Handles the edgecase when there is a single row in the middle of the matrix. In this case we dont
                //want to double count the values in this row, which we have already counted in the first loop above.
                if (rowStart == rowEnd) {
                    break;
                }
                result.add(array[rowEnd][i]);
            }

            for (int i = rowEnd - 1; i > rowStart; i--) {
                //Handles the edgecase when there is a single col in the middle of the matrix. In this case we dont
                //want to double count the values in this row, which we have already counted in the first loop above.
                if (colStart == colEnd) {
                    break;
                }
                result.add(array[i][colStart]);
            }

            rowStart += 1;
            colStart += 1;
            rowEnd -= 1;
            colEnd -= 1;

        }

        return result;
    }
}
