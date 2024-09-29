class Solution {
//     public int findDuplicate(int[] nums) {
//         int slow = nums[0];
//         int fast= nums[0];
//         do
//         {
//             slow=nums[slow];
//             fast=nums[fast];
//             fast=nums[fast];
//         }while(slow!=fast);
        
//         fast= nums[0];
//         while(slow!=fast)
//         {
//             slow=nums[slow];
//             fast=nums[fast];
//         }
//         return slow;
//     }
    public int findDuplicate(int[] nums) {
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            int index= Math.abs(nums[i]);
            if(nums[index-1]>0)
            {
                nums[index-1]=-nums[index-1];
            }
            else
            {
                return index;
            }
        }
        
        return -1;
    }
}