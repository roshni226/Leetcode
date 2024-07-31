class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!= t.length()) return false;
        int n= s.length();
        HashMap<Character, Character> st= new HashMap<>();
        HashMap<Character, Character> ts= new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            char chs= s.charAt(i);
            char cht= t.charAt(i);
            
            //check for s to t mapping
            if(st.containsKey(chs))
            {
                if(st.get(chs)!= cht)
                {
                    return false;
                }
            }
            else
            {
                st.put(chs,cht);
            }
            
            //chech for t to s mapping
            if(ts.containsKey(cht))
            {
                if(ts.get(cht)!=chs)
                {
                    return false;
                }
            }
            else
            {
                ts.put(cht,chs);
            }
        }
        return true;
    }
}