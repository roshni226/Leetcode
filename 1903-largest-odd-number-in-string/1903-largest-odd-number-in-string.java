class Solution {
    public String largestOddNumber(String num) {
        if((int)num.charAt(num.length()-1)%2!=0)
            return num;
        int i=num.length()-2;
        while(i>=0)
        {
            if((int)num.charAt(i)%2!=0)
                return num.substring(0,i+1);
            i--;
        }
        return "";
        
    }
}