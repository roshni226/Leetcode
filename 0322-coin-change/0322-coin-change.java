class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int dp[][]= new int[n+1][amount+1];
        //initialization
        //initialize entire table with infinity
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=amount;j++)
            {
                dp[i][j]= Integer.MAX_VALUE;
            }
        }
        
        for(int i=0;i<=n;i++)
        {
            //No. of coins needed to make amount 0 will be zero.
            dp[i][0]=0;
        }
        
        //Tabulation code
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j>=coins[i-1] && dp[i][j-coins[i-1]]!= Integer.MAX_VALUE)
                {
                    dp[i][j]=Integer.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount]!=Integer.MAX_VALUE?dp[n][amount]:-1;
        
    }
}