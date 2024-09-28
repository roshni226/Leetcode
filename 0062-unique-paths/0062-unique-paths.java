class Solution {
    public int count(int i, int j, int n, int m, int dp[][])
    {
        if(i>=n || j>=m) return 0; 
        if(i==n-1 && j==m-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=count(i,j+1,n,m,dp);
        int bottom= count(i+1,j,n,m,dp);
        return dp[i][j]=right+bottom;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<n;i++)    
            Arrays.fill(dp[i],-1);
        return count(0,0,n,m,dp);
    }
}