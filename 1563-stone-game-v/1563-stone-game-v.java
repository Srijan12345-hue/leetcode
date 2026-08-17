class Solution {
    Integer [][] dp;
    public int stoneGameV(int[] arr) {
        int n=arr.length;
        int l=0;
        int r=n-1;
          dp = new Integer[n][n];
        
        int [] prefix= new int[n+1];
        prefix[0]=0;
        for(int i=1;i<= n;i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
       int ans= score(l,r,prefix);
       return ans;
        
    }
    public int score(int l,int r, int[] prefix){
        if(l>=r) return 0;
        if(dp[l][r]!= null) return dp[l][r];
        int max=0;
        for(int k=l; k < r; k++){
            
            int left= prefix[k+1] - prefix[l];
            int right= prefix[r+1] - prefix[k+1];
            int scorea= Math.min(left,right);
            if(left > right){
                max = Math.max(scorea + score(k+1,r,prefix),max);
            }
            else{
                max = Math.max(scorea + score(l,k,prefix),max);

            }
            if(left== right){
               max = Math.max(
                    max,
                    left + Math.max(
                        score(l, k, prefix),
                        score(k + 1, r, prefix)
                    )
                );
            }

            
        }
        return dp[l][r]=max;
        
            }
}