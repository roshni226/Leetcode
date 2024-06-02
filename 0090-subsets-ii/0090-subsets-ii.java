import java.util.*;
class Solution {
    public void allUniqueSub(int []nums, int n, List<Integer> temp,HashSet<List<Integer>> set)
    {
        if(n==0)
        {
            set.add(new ArrayList<Integer>(temp));
            return;
        }
        //to include
        temp.add(nums[n-1]);
        allUniqueSub(nums,n-1,temp,set);
        temp.remove(temp.size() - 1);  // backtrack
        
        //to exclude
        allUniqueSub(nums,n-1,temp,set);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        HashSet<List<Integer>> set= new HashSet<>();
        Arrays.sort(nums);
        allUniqueSub(nums,nums.length,new ArrayList<Integer>(),set);
        ans.addAll(set);
        return ans;
    }
}