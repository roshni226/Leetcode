class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       
        Set<List<Integer>> st= new HashSet<>();
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                Set<Long> map= new HashSet<>();
                for(int k=j+1;k<n;k++)
                {
                    long sum= (long)nums[i]+(long)nums[j]+(long)nums[k];
                    long fourth= target-sum;
                    if(map.contains(fourth))
                    {
                        List<Integer> temp= new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        temp.sort(Integer :: compareTo);
                        st.add(temp);
                    }
                    map.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> ans= new ArrayList<>(st);
        return ans;
    }
}