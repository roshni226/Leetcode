class Solution {
    public int lis(int[] nums, int n,int ind,int prev, int dp[][])
    {
        if(ind==n)
        {
            return 0;
        }
        if(dp[ind+1][prev+1]!=-1) return dp[ind+1][prev+1];
        
        if(prev==-1||nums[ind]>nums[prev])
        {
            dp[ind+1][prev+1]=Integer.max(1+lis(nums,n,ind+1,ind,dp),
                                          lis(nums,n,ind+1,prev,dp));
        }
        else
        {
            dp[ind+1][prev+1]=lis(nums,n,ind+1,prev,dp);
        }
        return dp[ind+1][prev+1];
    }
        
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int [n+1][n+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return lis(nums,n,0,-1,dp);
    }
}