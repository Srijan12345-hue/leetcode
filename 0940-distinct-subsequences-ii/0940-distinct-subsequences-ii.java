class Solution {
   private static final int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        int [] dp=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            int charindex=s.charAt(i)-'a';
            dp[charindex]=sum(dp) + 1;

        }
        return sum(dp);
        
    }
    public int sum(int [] arr){
        int total=0;
        for(int num : arr){
            total = (total + num) % MOD;

        }
        return total;
    }
}