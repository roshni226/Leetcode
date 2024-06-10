class Solution {
    public int numTrees(int n) {
        //direct application of catalans number
        //cn= Σ(i=0 to n-1) ci*cn-i-1
        int dp[]= new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<=i-1;j++)
            {
                int leftWays= dp[j];
                int rightWays= dp[i-j-1];
                dp[i]+=leftWays*rightWays;
            }
        }
        return dp[n];
    }
}