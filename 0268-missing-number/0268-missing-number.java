class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int num=0;
        Arrays.sort(nums);
        if(nums[0]==0) num=n;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]+1!=nums[i+1])
            {
                num=nums[i]+1;
            }
        }
        return num;
    }
}