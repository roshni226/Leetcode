class Solution {
    public boolean canPartition(int[] nums) {
        int target=0,n=nums.length;
        for(int i=0;i<n;i++)
        {
            target+=nums[i];
        }
        if(target%2!=0)
        {
            return false;
        }
        target/=2;
        
        //reduced to target sum problem
        boolean dp[][]= new boolean[n+1][target+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(j>=nums[i-1])
                {
                    dp[i][j]=dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}