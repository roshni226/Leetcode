class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length;
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            maxi=Integer.max(maxi,sum);
            sum=sum<0?0:sum;
        }
        return maxi;
    }
}