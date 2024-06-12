class Solution {
    // public int func(int nums[],int n, int dp[])
    // {
    //     if(n==nums.length||n==nums.length+1)
    //     {
    //         return 0;
    //     }
    //     if(dp[n]!=-1) return dp[n];
    //     //take or not take
    //     int take=nums[n]+func(nums,n+2,dp);
    //     int notTake=func(nums,n+1,dp);
    //     int ans= Integer.max(take,notTake);
    //     return dp[n]=ans;
    // }
    // public int rob(int[] nums) {
    //     int dp[]= new int[nums.length+1];
    //     Arrays.fill(dp,-1);
    //     return func(nums,0,dp);
    // }
    public int rob(int[] nums) {
        int dp[]= new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=nums.length;i++)
        {
            int take= nums[i-1]+dp[i-2];
            int notTake= dp[i-1];
            dp[i]=Integer.max(take,notTake);
        }
        return dp[nums.length];
    }
}