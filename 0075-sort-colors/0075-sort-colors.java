import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
        int n= nums.length;
        int low=0;
        int mid=0;
        int high=n-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(mid,low, nums);
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
                swap(mid,high,nums);
                high--;
            }
        }
    }
    public void swap(int a,int b, int nums[])
    {
        int t= nums[a];
        nums[a]= nums[b];
        nums[b]= t;
    }
}