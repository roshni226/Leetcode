class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        
         int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int value = mp.get(s.charAt(i));  
            // If the current numeral is less than the next numeral, subtract it
            if (i + 1 < s.length() && value < mp.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                // Otherwise, add it
                result += value;
            }
        }
        
        return result;
    }
}