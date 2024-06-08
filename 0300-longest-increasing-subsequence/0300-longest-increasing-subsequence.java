class Solution {
    
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        int nums2[]= new int[set.size()];        
        int k=0;
        for(int i:set)
        {
            nums2[k++]=i;
        }
        int m= nums2.length;
        //sort the array
        Arrays.sort(nums2);
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;
        
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
                    dp[i][j]= Integer.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}