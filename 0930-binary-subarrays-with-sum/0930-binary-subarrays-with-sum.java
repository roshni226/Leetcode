class Solution {
    public int util(int[] nums, int k)
    {
        //function to find count of subarrays with sum<=goal
        if(k<0) return 0;
        int n= nums.length;
        int l=0,r=0,sum=0,ans=0;
        
        while(r<n)
        {
            sum+=nums[r];
            while(sum>k )//&& l<=r)
            {
                sum-=nums[l];
                l++;
            }
                      
            ans=ans+(r-l+1);
            r++;
        }
        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return util(nums,goal)-util(nums,goal-1);
    }
}