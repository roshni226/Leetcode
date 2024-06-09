class Solution {
    public int lis(int[] nums, int n,int ind,int prev, int dp[][])
    {
        if(ind==n+1)
        {
            return 0;
        }
        if(dp[ind][prev]!=-1) return dp[ind][prev];
        
        if(prev==0||nums[ind-1]>nums[prev-1])
        {
            dp[ind][prev]=Integer.max(1+lis(nums,n,ind+1,ind,dp),
                                          lis(nums,n,ind+1,prev,dp));
        }
        else
        {
            dp[ind][prev]=lis(nums,n,ind+1,prev,dp);
        }
        return dp[ind][prev];
    }
        
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int [n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lis(nums,n,1,0,dp);
    }
}