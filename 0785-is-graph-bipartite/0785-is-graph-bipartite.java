class Solution {
    public boolean dfs(int node, int col, int[] colour, int[][] grid)
    {
        colour[node]=col;
        for(int i:grid[node])
        {
            if(colour[i]==-1)
            {
                if(dfs(i,1-col,colour,grid)==false)
                    return false;
            }
            else if(colour[i]==col)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] grid) {
        int n=grid.length;
        int colour[]= new int[n];
        for(int i=0;i<n;i++)
        {
            colour[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            if(colour[i]==-1)
            {
                if(!dfs(i,0,colour,grid)) return false;
            }
        }
        return true;
    }
}