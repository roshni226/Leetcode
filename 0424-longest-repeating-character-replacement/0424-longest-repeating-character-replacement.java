class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0,r=0,len=0,maxlen=0, maxfreq=0;
        Map<Character,Integer> mp= new HashMap<>();
        while(r<n)
        {
            mp.put(s.charAt(r),mp.getOrDefault(s.charAt(r),0)+1);
            len=r-l+1;
            maxfreq=Math.max(maxfreq,mp.get(s.charAt(r)));
            if(len-maxfreq>k)
            {
                mp.put(s.charAt(l),mp.get(s.charAt(l))-1);
                
                l++;
            }
            if(len-maxfreq<=k)
            {
                maxlen=Math.max(maxlen,len);
            }
            r++;
        }
        return maxlen;
    }
}