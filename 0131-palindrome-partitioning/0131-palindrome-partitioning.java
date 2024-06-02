class Solution {
    public boolean isPalindrome(String s, int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public void func(String s, int ind, List<String> temp, List<List<String>> ans)
    {
        if(ind==s.length())
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                temp.add(s.substring(ind,i+1));
                func(s,i+1,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> temp= new ArrayList<>();
        func(s,0,temp,ans);
        return ans;
    }
}