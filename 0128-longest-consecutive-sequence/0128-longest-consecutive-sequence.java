class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int lastSmallest=Integer.MIN_VALUE;
        int count=0;
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            if(lastSmallest==nums[i]-1)
            {
                count++;
                lastSmallest=nums[i];
            }
            else if(lastSmallest==nums[i])
            {
                continue;
            }
            else
            {
                count=1;
                lastSmallest=nums[i];
            }
            maxi=Math.max(maxi,count);
        }
        
        return maxi;
    }
}