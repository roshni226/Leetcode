class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers= new ArrayList<>();
        int fact=1;
        for(int i=1;i<n;i++)
        {
            fact*=i;
        }
        for(int i=1;i<=n;i++)
        {
            numbers.add(i);
        }
        String ans="";
        k=k-1;
        while(true)
        {
            //k/fact <-- index of starting number
            ans+=(char)(numbers.get(k/fact)+'0');
            numbers.remove(k/fact);
            if(numbers.size()==0)
            {
                break;
            }
            
            k%=fact;
            fact/=(numbers.size());
        }
        return ans;
    }
}