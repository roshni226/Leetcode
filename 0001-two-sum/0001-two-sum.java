// class Solution {
//   public int[] twoSum(int[] nums, int target) {
//     Map<Integer, Integer> numToIndex = new HashMap<>();

//     for (int i = 0; i < nums.length; ++i) {
//       if (numToIndex.containsKey(target - nums[i]))
//         return new int[] {numToIndex.get(target - nums[i]), i};
//       numToIndex.put(nums[i], i);
//     }

//     throw new IllegalArgumentException();
//   }
// }
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n = nums.length;
//         int[] ans = new int[2];
//         ans[0] = ans[1] = 0;
//         HashMap<Integer,Integer> mpp = new HashMap<>(); //elem, index
//         for(int i =0;i < n; i++){
//             int num = nums[i];
//             int moreNeeded = target - num;
//             if(mpp.containsKey(moreNeeded)){
//                 ans[0] = mpp.get(moreNeeded);
//                 ans[1] = i;
//             }
//             mpp.put(nums[i],i);

//         }
//         return ans;
//     }
// }
    
class Solution{
    public int[] twoSum(int[] nums, int target)
    {
        int n= nums.length;
        int ans[]= new int[2];
        HashMap<Integer, Integer> mp= new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int sum1= nums[i];
            int sum2=target- sum1;
            if(mp.containsKey(sum2))
            {
                ans[0]=i;
                ans[1]=mp.get(sum2);
                break;
            }
            else
            {
                mp.put(sum1,i);
            }
        }
        return ans;
    }
}