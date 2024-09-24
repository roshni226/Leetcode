class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[]= new int[2];
        ans[0]=-1;
        ans[1]=-1;
        int n= nums.length;
        HashMap<Integer,Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int curr= nums[i];
            int want= target-curr;
            if(mp.containsKey(want))
            {
                ans[0]=i;
                ans[1]= mp.get(want);
                break;
            }
            mp.put(curr,i);
            
        }
        return ans;
    }
}