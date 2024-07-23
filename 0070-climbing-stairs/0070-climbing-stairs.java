class Solution {
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            //ways(n)= ways(n-1)+ways(n-2)
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}