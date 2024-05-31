import java.util.*;
class Solution {
    public int trap(int[] height) {
//TWO POINTER
//         int n=height.length;
//         int maxLeft=0,maxRight=0;
//         int left=0, right=n-1;
//         int res=0;
//         while(left<right)
//         {
//             maxLeft= Math.max(maxLeft,height[left]);
//             maxRight= Math.max(maxRight,height[right]);
            
//             if(maxLeft<=maxRight)//only dependent on maxLeft
//             {
//                 //calculating trapped water for height[left]
//                 res+=(maxLeft-height[left]);
//                 left++;
//             }
//             else//only dependent on maxRight
//             {
//                 //calculating trapped water for height[right]
//                 res+=(maxRight-height[right]);
//                 right--;
//             }
//         }
//         return res;
        
//DP or Auxiliary Array
        int n= height.length;
        //Creating left max 
        int leftMax[]= new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++)
        {
            leftMax[i]=Math.max(height[i],leftMax[i-1]);
        }
        
        //Creating right max
        int rightMax[]= new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rightMax[i]=Math.max(height[i],rightMax[i+1]);
        }
        
        //Calculating total
        int res=0;
        for(int i=0;i<n;i++)
        {
            int W= Math.min(leftMax[i],rightMax[i]);
            res+=(W-height[i]);
        }
        return res;
    }
}