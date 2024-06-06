class Solution {
    public int min(int a,int b,int c)
    {
        if(a>=b && c>=b)
        {
            return b;
        }
        else if(b>=a &&c>=a)
        {
            return a;
        }
        else 
        {
            return c;
        }
    }
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m=word2.length();
        int dp[][]= new int[n+1][m+1];
        
        //initialization
        for(int i=0;i<=n;i++)//length of s2 is 0
        {
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++)//length of s1 is 0
        {
            dp[0][j]=j;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1;
                }
            }
        }
        return dp[n][m];
    }
}