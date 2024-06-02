class Solution {
    public void comb(int c[], int n, int target, List<Integer> temp, List<List<Integer>> ans)
    {
        if(n==0)
        {
            if(target==0){
            ans.add(new ArrayList<>(temp));
            }
            return;
        }
        
        //pick if remaining target> curr element
        if(target>=c[n-1])
        {
            temp.add(c[n-1]);
            comb(c,n,target-c[n-1],temp,ans);
            temp.remove(temp.size()-1);// backtrack for next cases
        }
        
        //exclude
        comb(c,n-1,target,temp,ans);
        
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        comb(candidates, candidates.length,target,temp,ans);
        return ans;
    }
}