class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n=A.length;
        int rof=-n+1;
        int cof= -n+1;
        int ans=0;
        for(int i=rof; i<n;i++){
            for(int j=cof;j<n;j++){
                ans = Math.max(ans, count1(A, B, i, j, n));

            }
        }
        return ans;
        
    }
    public int count1(int [][] A, int[][] B, int rof, int cof,int n){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+ rof>=0 && i+rof < n && j+cof>=0 && j+cof<n){
               if (A[i][j] == 1 && B[i + rof][j + cof] == 1){
                    count++;
                }
                }
            }
        }
        return count;
    }
}