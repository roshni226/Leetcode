class Solution {
    public void swap(int i, int j, int nums[])
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    public void recur(int nums[],int index,List<List<Integer>> ans)
    {
        if(index==nums.length)
        {
            List<Integer> temp= new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                temp.add(nums[i]);
            }
            ans.add(new ArrayList <>(temp));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(i,index,nums);
            recur(nums,index+1,ans);
            swap(i,index,nums);//backtrack
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        recur(nums,0,ans);
        return ans;
                
    }
}