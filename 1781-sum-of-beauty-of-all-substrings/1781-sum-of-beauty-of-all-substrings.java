class Solution {
    public int beautySum(String S) {
        int n= S.length();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            int freq[]= new int[26];
            
            for(int j=i;j<n;j++)
            {
                freq[S.charAt(j) -'a']++;
                sum+=calcBeauty(freq);  
            }
        }
        
        return sum;
    }
    public int calcBeauty(int freq[])
    {
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        for(int f: freq)
        {
            if(f!=0)
            {
                max= Math.max(max,f);
                min= Math.min(min,f); 
            }
        }
        return max-min;
    }
}