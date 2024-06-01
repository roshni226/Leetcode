import java.util.*;
class Solution {
    static String keypad[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void printComb(String s, int i, List<String> temp, String comb)
    {
        if(i==s.length())
        {
            temp.add(comb);
            return;
        }
        
        char curr= s.charAt(i);
        String keyval= keypad[curr-'0'];

        for(int a=0;a<keyval.length();a++)
        {
            printComb(s,i+1,temp,comb+keyval.charAt(a));
        }
        return;
    }
    public List<String> letterCombinations(String digits){
        List<String> temp = new ArrayList<>();
        if(digits.length()==0)
        {
            return temp;
        }
        
        printComb(digits,0,temp,"");
        return temp;
        
    }
}
