class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean firstColZero = false;

        // Mark rows and columns
        for (int i = 0; i < n; i++) {

            // Check first column separately
            if (matrix[i][0] == 0) {
                firstColZero = true;
            }

            // Start from column 1
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Process inner matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Process first row
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Process first column
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}