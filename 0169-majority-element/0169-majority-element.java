class Solution {
    //Moore's Voting algorithm
    public int majorityElement(int[] nums) {
        int n= nums.length;
        int candidate=-1,count=0;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                candidate=nums[i];
            }
            if(candidate==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        int elecount=0;
        //verifying
        if(count!=0)
        {
            for(int i=0;i<n;i++)
            {
                if(nums[i]==candidate)
                {
                    elecount++;
                }
            }
            if(elecount>n/2)
            {
                return candidate;
            }
            else
            {
                return -1;
            }
        }
        return -1;
    }
}