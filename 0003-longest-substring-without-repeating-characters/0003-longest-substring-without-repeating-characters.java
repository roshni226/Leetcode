class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n= s.length();
        int len=0,l=0,r=0;
        int maxlen=0;
        Map<Character, Integer> mp= new HashMap<>();
        while(r<n)
        {
            if(mp.containsKey(s.charAt(r)) && mp.get(s.charAt(r))>=l)
            {
                l=mp.get(s.charAt(r))+1;
            }
            mp.put(s.charAt(r),r);
            len=r-l+1;
            maxlen=Math.max(len,maxlen);
            r++;
        }
        return maxlen;
    }
}