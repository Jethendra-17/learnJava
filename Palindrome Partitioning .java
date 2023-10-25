//User function Template for Java

class Solution{
   static int palindromicPartition(String s)
    {
        int n=s.length();
        
        
        boolean isPalin[][]=new boolean[n][n];
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        
        for(int i=0;i<n;i++){
            isPalin[i][i]=true;
        }
    
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j)){
                  if (j - i == 1) {
                        isPalin[i][j] = true;
                    } else {
                        isPalin[i][j] = isPalin[i + 1][j - 1];
                    }
                }
            }
        }
        
     return fun(s,0,n,isPalin,dp)-1;
    }
    
    static int fun(String s,int i,int n,boolean isPalin[][],int dp[]){
       if(i==n){
           return 0;
       }
       
       if(dp[i]!=-1){
           return dp[i];
       }
       
       int ans=Integer.MAX_VALUE;
       for(int j=i;j<n;j++){
           if(isPalin[i][j]){
            int cost = 1+ fun(s,j+1,n,isPalin,dp);
            ans=Math.min(cost,ans);
           }
       }
          return dp[i]=ans;
    }

}
