class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        int n= time.length;
        for(int i=0;i<n;i++)
        {
            int remainder = time[i]%60;
            int target = 60-remainder;
            
            if(remainder == 0)
            {
                count+=map.getOrDefault(0,0);
            }
            else if(remainder == 30)
            {
                count+=map.getOrDefault(30,0);
            }
            else
            {
                count+=map.getOrDefault(target,0);
            }
            map.put(remainder,map.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}