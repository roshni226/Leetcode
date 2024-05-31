class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int maxLeft=0,maxRight=0;
        int left=0, right=n-1;
        int res=0;
        while(left<right)
        {
            maxLeft= Math.max(maxLeft,height[left]);
            maxRight= Math.max(maxRight,height[right]);
            
            if(maxLeft<=maxRight)//only dependent on maxLeft
            {
                //calculating trapped water for height[left]
                res+=(maxLeft-height[left]);
                left++;
            }
            else//only dependent on maxRight
            {
                //calculating trapped water for height[right]
                res+=(maxRight-height[right]);
                right--;
            }
        }
        return res;
        
    }
}