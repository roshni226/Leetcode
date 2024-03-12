import java.util.*;
import java.io.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi= -100000;
        int sum=0;
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            
            if(sum>maxi)
            {
                maxi=sum;
            }
            
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxi;
    }
}