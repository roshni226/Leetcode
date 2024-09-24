//Better Solution O(N^3logM) O(N)
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
       
//         Set<List<Integer>> st= new HashSet<>();
//         int n= nums.length;
//         for(int i=0;i<n;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 Set<Long> map= new HashSet<>();
//                 for(int k=j+1;k<n;k++)
//                 {
//                     long sum= (long)nums[i]+(long)nums[j]+(long)nums[k];
//                     long fourth= target-sum;
//                     if(map.contains(fourth))
//                     {
//                         List<Integer> temp= new ArrayList<>();
//                         temp.add(nums[i]);
//                         temp.add(nums[j]);
//                         temp.add(nums[k]);
//                         temp.add((int)fourth);
//                         temp.sort(Integer :: compareTo);
//                         st.add(temp);
//                     }
//                     map.add((long)nums[k]);
//                 }
//             }
//         }
//         List<List<Integer>> ans= new ArrayList<>(st);
//         return ans;
//     }
// }

//Optimal O(N^3) O(1)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        int n= nums.length;
        for(int i=0;i<n;i++)
        {   
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l)
                {
                    List<Integer> temp= new ArrayList<>();
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
                    if(target==sum)
                    {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        
                        while(k<l && nums[k]==nums[k-1] ) k++;
                        while(k<l && nums[l]==nums[l+1] ) l--;
                    }
                    else if(sum>target) l--;
                    else k++;
                }
            }
        }
        
        return ans;
    }  
}






