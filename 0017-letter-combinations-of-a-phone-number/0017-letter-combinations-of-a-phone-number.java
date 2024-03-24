// class Solution {
//     public static String[] keypad= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//     public static List<String> letterCombinations(String digits) {
        
//         formList(digits,0,"");
//         return str;
//     }
//     public static List<String> str= new ArrayList<>();
//     public static void formList(String digits,int digidx, String combinationStr)
//     {
//         if(digidx == digits.length())
//         {
//             return;
//         }
//         str.add(combinationStr);
//         char keypadIndex= digits.charAt(digidx);
//         String curr= keypad[keypadIndex-'0'];//retrieving string from keypad suppose keypadIndex=2 so '2'-'0'=50-49=2 and we get abc as curr
//         for(int i=0;i<curr.length();i++)
//         {
//             formList(digits,digidx,combinationStr+curr.charAt(i));
//         }
//     }
// }

class Solution {
    public static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        formList(digits, 0, "", result);
        return result;
    }

    public static void formList(String digits, int digidx, String combinationStr, List<String> result) {
        if (digidx == digits.length()) {
            result.add(combinationStr);
            return;
        }
        char keypadIndex = digits.charAt(digidx);
        String curr = keypad[keypadIndex - '0'];
        for (int i = 0; i < curr.length(); i++) {
            formList(digits, digidx + 1, combinationStr + curr.charAt(i), result);
        }
    }
}
