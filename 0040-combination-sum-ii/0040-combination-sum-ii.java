class Solution {
    public void comb(int c[], int ind, int target, List<Integer> temp, List<List<Integer>> ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind;i<c.length;i++)
        {
            if(i!=ind && c[i]==c[i-1]) continue;
            if(target>=c[i])
            {
                temp.add(c[i]);
                comb(c,i+1,target-c[i],temp,ans);
                temp.remove(temp.size()-1);
            }
        }
          
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        comb(candidates,0,target,temp,ans);
        return ans;
        
    }
}