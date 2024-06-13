class Solution {
    // public int tribonacci(int n) {
    //     if(n==0) return 0;
    //     if(n==1||n==2) return 1;
    //     int n0=0,n1=1,n2=1,n3=0;
    //     for(int i=3;i<=n;i++)
    //     {
    //         n3=n0+n1+n2;
    //         n0=n1;
    //         n1=n2;
    //         n2=n3;
    //     }
    //     return n3;
    // }
//     public int helper(int n, int[]dp)
//     {
//         if(n==0) return 0;
//         if(n==1||n==2) return 1;
//         if(dp[n]!=-1) return dp[n];
        
//         return dp[n]=helper(n-1,dp)+helper(n-2,dp)+helper(n-3,dp);        
//     }
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}