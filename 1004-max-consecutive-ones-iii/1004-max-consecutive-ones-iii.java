class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int zeros=0;
        int l=0,r=0;
        int len=0,maxlen=0;
        while(r<n)
        {
            if(nums[r]==0)
                zeros++;
            if(zeros>k)
            {
                if(nums[l]==0)
                    zeros--;
                l++;
            }
            if(zeros<=k)
            {
                len=r-l+1;
                maxlen=Math.max(maxlen,len);
            }
            r++;
        }
        return maxlen;
    }
}