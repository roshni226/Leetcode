class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();
        
        // Convert to lowercase and filter out non-alphanumeric characters
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        // Check if the cleaned string is a palindrome
        String cleanedString = cleaned.toString();
        int n = cleanedString.length();
        for (int i = 0; i < n / 2; i++) {
            if (cleanedString.charAt(i) != cleanedString.charAt(n - i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}
