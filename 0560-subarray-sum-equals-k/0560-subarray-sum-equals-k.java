class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        int presum=0,ans=0;
        Map<Integer,Integer> mp= new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<n;i++)
        {
            presum+=nums[i];
            int pre=presum-k; 
            if(mp.containsKey(pre))
            {
                ans+=mp.get(pre);
            }
            mp.put(presum,mp.getOrDefault(presum,0)+1);
        }
        return ans;
    }
}