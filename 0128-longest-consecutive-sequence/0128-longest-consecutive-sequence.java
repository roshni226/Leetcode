//Better- O(NlogN) O(1)
// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int n= nums.length;
//         Arrays.sort(nums);
//         int lastSmallest=Integer.MIN_VALUE;
//         int count=0;
//         int maxi=0;
//         for(int i=0;i<n;i++)
//         {
//             if(lastSmallest==nums[i]-1)
//             {
//                 count++;
//                 lastSmallest=nums[i];
//             }
//             else if(lastSmallest==nums[i])
//             {
//                 continue;
//             }
//             else
//             {
//                 count=1;
//                 lastSmallest=nums[i];
//             }
//             maxi=Math.max(maxi,count);
//         }
        
//         return maxi;
//     }
// }

//Optimal O(N) O(N)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n==0) return 0;
        Set<Integer> set= new HashSet<>();
        int count=0,maxi=0;
        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }
        
        for(int i=0;i<n;i++)
        {
            int x= nums[i];
            if(set.contains(nums[i]-1))
            {
                continue;
            }
            else
            {
                count=1;
                while(set.contains(x+1))
                {
                    x=x+1;
                    count++;
                }
            }
            maxi=Math.max(count,maxi);
        }
        return maxi;
    }
}