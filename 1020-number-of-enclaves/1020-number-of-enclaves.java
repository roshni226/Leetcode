class Solution {
    public void dfs(int row, int col, int[][] vis, int[][] grid)
    {
        vis[row][col]=1;
        int n= grid.length;
        int m= grid[0].length;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        
        for(int i=0;i<4;i++)
        {
            int nrow= row + dx[i];
            int ncol= col + dy[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
                dfs(nrow, ncol, vis,grid);
        }
    }
    public int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int vis[][]= new int[n][m];
        //perform dfs on all the ones on the boundary, mark them as visited 
        //remaining ones will be all the ones which are not connected to the boundary
        //they will be part of the answer
        for(int i=0;i<m;i++)
        {
            //first row
            if(vis[0][i]==0 && grid[0][i]==1)
                dfs(0,i,vis,grid);
            //last row
            if(vis[n-1][i]==0 && grid[n-1][i]==1)
                dfs(n-1,i,vis,grid);
        }
        
        for(int i=0;i<n;i++)
        {
            //first column
            if(vis[i][0]==0 && grid[i][0]==1)
                dfs(i,0,vis,grid);
            //last column
            if(vis[i][m-1]==0 && grid[i][m-1]==1)
                dfs(i,m-1,vis,grid);
        }
        
        int count=0;
        //for all the unvisited ones increse the count
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                    count++;
            }
        }
        
        return count;
    }
}