class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=-1;
        int n= nums.length;
        for(i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                j=i;
                break;
            }
        }
        
        if(j!=-1)
        {
            for(i=j+1;i<n;i++)
            {
                if(nums[i]!=0)
                {
                    int t=nums[j];
                    nums[j]=nums[i];
                    nums[i]=t;
                    j++;
                }
            }
        }
    }
}