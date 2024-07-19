class Solution {
    public void mark_an_island(char[][] grid, int x, int y, int rows, int cols)
    {
        if(x<0||y<0||x>=rows||y>=cols||grid[x][y]=='0'||grid[x][y]=='2')
        {
            return;
        }
        //mark current cell
        grid[x][y]='2';
        
        // mark in all four directions up, down, right, left
        mark_an_island(grid,x,y+1,rows, cols);
        mark_an_island(grid,x,y-1,rows,cols);
        mark_an_island(grid,x+1,y,rows,cols);
        mark_an_island(grid,x-1,y,rows,cols);
    }
    public int numIslands(char[][] grid) {
        int rows= grid.length;
        int cols= grid[0].length;
        if(rows==0) return 0;// empty grid
        int no_of_islands=0;
        
        //make a dfs call for each cell
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]=='1')
                {
                    mark_an_island(grid, i,j,rows,cols);
                    no_of_islands+=1;
                    
                }
            }
        }
        return no_of_islands;
    }
}