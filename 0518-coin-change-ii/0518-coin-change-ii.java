class Solution {
    public int change(int amount, int[] coins) {
        int n= coins.length;
        
        int dp[][]= new int[n+1][amount+1];
        dp[0][0]=1;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                if(j>=coins[i-1])
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}