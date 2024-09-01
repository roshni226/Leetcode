class Solution {
    public boolean check(int[] nums) {
        int x=-1;
        int n= nums.length;
        int b[]= new int[n];
        b[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            b[i]=nums[i];
            if(nums[i]<nums[i-1])
            {
                x=i;
            }
        }
        if (x == -1) {
            return true;
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=b[(i+x)%n])
            {
                return false;
            }
        }
        return true;
        
    }
}