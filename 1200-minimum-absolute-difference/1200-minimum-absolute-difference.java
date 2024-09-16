class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans= new ArrayList<>();
        //sort array
        Arrays.sort(arr);
        
        //find minimum difference
        int minD=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++)
        {
            int diff= arr[i]-arr[i-1];
            if(diff<minD)
            {
                minD=diff;
            }
        }
        
        //store the answer pairs
        List<Integer> temp= new ArrayList<>();
        for(int i=1;i<arr.length;i++)
        {
            int diff=arr[i]-arr[i-1];
            if(diff==minD)
            {
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        
        return ans;
    }
}