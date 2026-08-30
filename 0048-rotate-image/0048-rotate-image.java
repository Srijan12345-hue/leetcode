class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n;j++){
                swap(matrix, i,j,j,i);
            }
        }
         for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
         
        
    }
    public void swap( int [][] mat, int m, int n, int x, int l){
        int temp=mat[m][n];
       mat[m][n]= mat[x][l];
       mat[x][l]= temp;
    }
}