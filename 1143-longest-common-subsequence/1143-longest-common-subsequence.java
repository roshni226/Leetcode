class Solution {
    public int lcs(String str1, String str2, int n, int m, int [][]dp)
    {
        //base case
        if(n==0||m==0)
        {
            return 0;
        }
        
        //check if subproblem is already solved
        if(dp[n][m]!=-1)
        {
            return dp[n][m];
        }
        
        //check if last character is same
        if(str1.charAt(n-1)==str2.charAt(m-1))
        {
            return dp[n][m]=1+lcs(str1,str2,n-1,m-1,dp);
        }
        else
        {
            return dp[n][m]= Integer.max(
                                        lcs(str1,str2,n-1,m,dp),
                                        lcs(str1,str2,n,m-1,dp)
                                        );
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {    for(int j=0;j<=m;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        return lcs(text1,text2,n,m,dp);
        
    }
}