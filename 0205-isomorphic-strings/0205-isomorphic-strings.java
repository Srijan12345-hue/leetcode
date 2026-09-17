class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n !=m) return false;
        int[] stot= new int[256];
         int[] ttos= new int[256];

        for(int i=0;i<n;i++){
            char a=s.charAt(i);
            char b=t.charAt(i);
            if(stot[a] !=0 && stot[a]  !=b) return false;
            if(ttos[b] !=0 && ttos[b]  !=a) return false;
            stot[a]=b;
            ttos[b]=a;
            
        }
        return true;
        
    }
}