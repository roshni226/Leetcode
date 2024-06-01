import java.util.*;
class Solution {
    String keypad[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
   public List<String> printComb(String s, int i, List<String> ans, StringBuilder comb) {
        if (i == s.length()) {
            ans.add(comb.toString());
            return ans;
        }

        char curr = s.charAt(i);
        String keyval = keypad[curr - '0'];

        for (int a = 0; a < keyval.length(); a++) {
            comb.append(keyval.charAt(a));
            printComb(s, i + 1, ans, comb);
            comb.deleteCharAt(comb.length() - 1); // backtrack
        }

        return ans; // Ensure we return the accumulated answers
}
    public List<String> letterCombinations(String digits){
        List<String> temp = new ArrayList<>();
        if (digits.isEmpty()) {
            return temp; // Return empty list if input is empty
        }
        StringBuilder comb=new StringBuilder();;
        return printComb(digits,0,temp,comb);
        
    }
}