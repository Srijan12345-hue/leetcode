class Solution {
    public int maxDepth(String s) {
        int max=0;
        int count=0;
         int n=s.length();
         for(int i=0;i<n;i++){
            if(s.charAt(i)=='(')
                count+=1;
            else if(s.charAt(i)==')')
                    count-=1;
            max=Math.max(max,count);
         }
         return max;
        
    }
}