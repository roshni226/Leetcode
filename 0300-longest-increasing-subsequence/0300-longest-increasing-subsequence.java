class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        int m= set.size();
        int nums2[]= new int[m];
        int a=0;
        for(int curr:set)
        {
            nums2[a++]=curr;
        }
            
        Arrays.sort(nums2);
        
        int dp[][]= new int[n+1][m+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(nums[i-1]==nums2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}