class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int total= Arrays.stream(nums).sum();
        if((target+total)%2!=0 || total<target || total+target<0)
        {
            return 0;
        }
        int s2= (total+target)/2;
        int zeroCount=0,k=0;
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                zeroCount++;
            }
            else
            {
                arr[k++]=nums[i];
            }
        }
        int dp[][]= new int[k+1][s2+1];
        dp[0][0]=1;
        for(int i=1;i<=k;i++)
        {
            for(int j=0;j<=s2;j++)
            {
                if(j>=arr[i-1])
                {
                    dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        //possible ways for 0's
        int zero= (int)Math.pow(2,zeroCount);
        return dp[k][s2]*zero;
    }
}