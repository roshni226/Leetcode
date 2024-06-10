class Solution {
//     static String s1;
//     public boolean isPalindrome(String s, int i, int j)
//     {
//         if(i==j)
//         {
//             return true;
//         }
//         if(i>j)//empty string
//         {
//             return true;
//         }
//         while(i<=j)
//         {
//             if(s.charAt(i)!=s.charAt(j))
//             {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public int palindromePartition(String s, int i, int j, int dp[][])
//     {
//         if(i==j)//sinle character palindrome
//         {
//             return 0;//<- no of partitions
//         }
//         if(isPalindrome(s,i,j))
//         {
//             return 0;
            
//         }
//         if(dp[i][j]!=-1)
//         {
//             return dp[i][j];
//         }
//         int min=Integer.MAX_VALUE;
//         for(int k=i;k<=j-1;k++)
//         {
//             int left=(dp[i][k]==-1)?dp[i][k]=palindromePartition(s,i,k,dp):dp[i][k];
//             int right=(dp[k+1][j]==-1)?dp[k+1][j]=palindromePartition(s,k+1,j,dp):dp[k+1][j];
//             int ans=left+right+1;//<- cost of current partition
//             min=Integer.min(min,ans);
            
//         }
//         return dp[i][j]=min;
//     }
//     public int minCut(String s) {
//         s1=s;
//         int n= s.length();
//         int dp[][]= new int[n][n];
//         for(int i=0;i<n;i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
//         return palindromePartition(s1,0,n-1,dp);
//     }
    boolean generatePalindrome(String s,boolean[][] pal)
    {
        int n = s.length();
 
        // Initialize the palindrome matrix for single
        // characters
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }
 
        // Iterate over different lengths of substrings
        for (int len = 2; len <= n; len++) {
            // Iterate over the starting positions of
            // substrings of current length
            for (int i = 0; i <= n - len; i++) {
 
                // Calculate the ending position of the
                // substring
                int j = i + len - 1;
 
                // Check if the characters at the starting
                // and ending positions are equal and if the
                // substring between them is a palindrome or
                // a single character
                if (s.charAt(i) == s.charAt(j)
                    && (len == 2 || pal[i + 1][j - 1])) {
 
                    // Mark the substring from i to j as a
                    // palindrome
                    pal[i][j] = true;
                }
            }
        }
 
        return true;
    }
 
    // Function to calculate the minimum number of cuts
    // required to make all substrings of 's' palindromic
    public int minCut(String s)
    {
        if (s.isEmpty())
            return 0;
        int n = s.length();
 
        // 2D array to store whether substring [i, j] is a
        // palindrome
        boolean[][] pal = new boolean[n][n];
 
        generatePalindrome(s, pal);
 
        // Array to store minimum cuts required to make
        // substring [i, n-1] palindromic
        int[] minCutDp = new int[n];
        Arrays.fill(minCutDp, Integer.MAX_VALUE);
 
        // There is no cut required for single character
        // as it is always palindrome
        minCutDp[0] = 0;
 
        // Iterate over the given string
        for (int i = 1; i < n; i++) {
 
            // Check if string 0 to i is palindrome.
            // Then minCut require will be 0.
            if (pal[0][i]) {
                minCutDp[i] = 0;
            }
            else {
                for (int j = i; j >= 1; j--) {
 
                    // If s[i] and s[j] are equal and the
                    // inner substring [i+1, j-1] is a
                    // palindrome or it has a length of 1
                    if (pal[j][i]) {
 
                        // Update the minimum cuts required
                        // if cutting at position 'j+1'
                        // results in a smaller value
                        if (minCutDp[j - 1] + 1
                            < minCutDp[i])
                            minCutDp[i]
                                = minCutDp[j - 1] + 1;
                    }
                }
            }
        }
 
        // Return the minimum cuts required for the entire
        // string 's'
        return minCutDp[n - 1];
    }
}