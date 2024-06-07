class Solution {
    public boolean isSubsequence(String s, String t) {
       
        if(s.length()==0) return true;
        int i=s.length()-1;
        int j=t.length()-1;
        int dup=i+1;
        int flag=0;
        while(i>=0 && j>=0)
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i--;
                j--;
                flag++;
            }
            else
            {
                j--;
            }
        }
        return flag==dup?true:false;
    }
}