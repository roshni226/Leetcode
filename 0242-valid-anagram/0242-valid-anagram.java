class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int n= s.length();
        char ch1[]= s.toCharArray();
        Arrays.sort(ch1);
        char ch2[]=t.toCharArray();
        Arrays.sort(ch2);
        for(int i=0;i<n;i++)
        {
            if(ch1[i]!=ch2[i])
                return false;
        }
        return true;
            
    }
}