class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        if(n != m) return false;
        String t=(s+s);
        return kmp(t,goal);
    }
    public boolean kmp(String t,String g){
        int n=t.length();
        int m=g.length();
        int [] lps=new int[m];
        int len=0;
        int i=1;
        while(i<m){
            if(g.charAt(i)==g.charAt(len)){
                len++;
                lps[i]=len;
                i++;


            }
            else{
                if(len!=0) len=lps[len-1];
                else{
                    lps[i]=0;
                  i++;
                }
            }
        }
        i=0;
        int j=0;
        while(i<n){
            if(t.charAt(i)==g.charAt(j))
            {
                i++;
                j++;
                 if(j==m) return true;
            }
            else{
                if(j!=0) j=lps[j-1];
                else i++;
            }
        }
        return false;
    }
}