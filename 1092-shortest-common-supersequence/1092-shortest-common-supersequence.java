class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int n= s1.length();
        int m= s2.length();
        
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0||j==0)
                {
                    dp[i][j]=0;
                }
            }
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        int lcs= dp[n][m];
        
        int scs=n+m-lcs;
        
        int i=n,j=m;
        String s="";
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                s=s1.charAt(i-1)+s;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                s=s1.charAt(i-1)+s;
                i--;
            }
            else
            {
                s=s2.charAt(j-1)+s;
                j--;
            }
        }
        while(i>0)
        {
            s=s1.charAt(i-1)+s;
            i--;
        }
        while(j>0)
        {
            s=s2.charAt(j-1)+s;
            j--;
        }
        return s;
    }
}