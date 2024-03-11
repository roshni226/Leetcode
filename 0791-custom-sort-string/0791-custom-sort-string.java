class Solution {
    public String customSortString(String order, String str) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        int[] a = new int[26];

        // Count the frequency of characters in order
        for (char c : order.toCharArray())
            a[c - 'a']++;

        // Iterate through each character in str
        for (char c : str.toCharArray()) {
            if (a[c - 'a'] == 0)
                s2.append(c);
            else
                a[c - 'a']++;
        }

        // Iterate through each character in order
        for (char c : order.toCharArray()) {
            while (a[c - 'a'] > 1) {
                s1.append(c);
                a[c - 'a']--;
            }
        }
        
        return s1.toString() + s2.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String order = "cba";
        String str = "abcd";
        System.out.println(solution.customSortString(order, str)); // Output should be "cbad"
    }
}