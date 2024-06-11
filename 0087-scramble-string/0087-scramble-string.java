class Solution {
    public HashMap<String,Boolean> mp= new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
        {
            return true;
        }
        int n=s1.length();
        if(n!=s2.length())
        {
            return false;
        }
        if(n==0)
        {
            return true;
        }
        String key=s1+" "+s2;
        if(mp.containsKey(key))
        {
            return mp.get(key);
        }
        //check for anagram
        // char temp1[]= s1.toCharArray();
        // char temp2[]= s2.toCharArray();
        // Arrays.sort(temp1);
        // Arrays.sort(temp2);
        // String copy1= new String(temp1);
        // String copy2= new String(temp2);
        // if(copy1.equals(copy2)!=true)
        // {
        //     mp.put(key,false);
        //     return false;
        // }
        boolean flag=false;
        for(int i=1;i<=n-1;i++)
        {
            //swap case
            if(isScramble(s1.substring(n-i,n),s2.substring(0,i))&& isScramble(s1.substring(0,n-i),s2.substring(i,n)))
            {
                mp.put(key,true);
                return true;
            }
            //not swap case
                  if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i,n),s2.substring(i,n)))
            {
                mp.put(key,true);
                return true;
            }
        }
        mp.put(key,false);
        return false;
    }
}