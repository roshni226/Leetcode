import java.util.*;
import java.io.*;
class Solution {
    public int[] nextPermutation(int[] nums) {
        int n= nums.length;
        //Finding Break point
        int idx=-1;// Index of break point
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                idx=i;
                break;
            }
        }

        //Checking for edge case: if arrangement is in descending order
        if(idx==-1)
        {
            Arrays.sort(nums);
            return nums;
        }

        //finding element just greater than the break point
        for(int i=n-1;i>idx;i--)
        {
            if(nums[i]>nums[idx])
            {
                int t=nums[i];
                nums[i]=nums[idx];
                nums[idx]=t;
                break;
            }
        }

        Arrays.sort(nums,idx+1,n);
        return nums;

    }
}