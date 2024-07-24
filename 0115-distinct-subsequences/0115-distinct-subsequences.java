class Solution {
//     public int count(String s, String t, int n, int m, int dp[][])
//     {
//         if(m==0)// t is exhausted<- valid subsequence found
//             return 1;
//         if(n==0 && m!=0)//s is exhausted but t is not<- no valid subsequence
//             return 0;
//         //subproblem computed
//         if(dp[n][m]!=-1) return dp[n][m];
        
//         if(s.charAt(n-1)==t.charAt(m-1))
//         {
//             //valid total count= including curr char+ excluding curr char
//             return count(s,t,n-1,m-1,dp)+count(s,t,n-1,m,dp);
//         }
//         else
//         {   //Invalid exclude 
//             return count(s,t,n-1,m,dp);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n=s.length();
//         int m=t.length();
        
//         int dp[][]= new int [n+1][m+1];
//         for(int i=0;i<=n;i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
        
//         return count(s,t,n,m,dp);
//     }
    
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        
        int dp[][]= new int [n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++)
        {
            dp[0][j]=0;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}