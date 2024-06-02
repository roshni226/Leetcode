class Solution {
    public void comb(int c[], int ind, List<Integer> temp, List<List<Integer>> ans)
    {
        ans.add(new ArrayList<>(temp));
            
        
        for(int i=ind;i<c.length;i++)
        {
            if(i!=ind && c[i]==c[i-1]) continue;
            temp.add(c[i]);
            comb(c,i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        comb(nums,0,temp,ans);
        return ans;
    }
}