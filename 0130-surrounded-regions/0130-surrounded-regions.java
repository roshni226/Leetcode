class Solution {
    public void dfs(int row, int col, int [][] vis, char [][] board)
    {
        vis[row][col]=1;
        int n= board.length;
        int m= board[0].length;
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        
        for(int i=0;i<4;i++)
        {
            int nrow=row+dx[i];
            int ncol=col+dy[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O')
            {
                dfs(nrow, ncol, vis, board);
            }
        }
    }
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int vis[][]= new int[n][m];
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        
        for(int i=0;i<m;i++)
        {
            //first row
            if(vis[0][i]==0 && board[0][i]=='O')
            {
                dfs(0,i,vis,board);
            }
            //last row
            if(vis[n-1][i]==0 && board[n-1][i]=='O')
            {
                dfs(n-1,i,vis,board);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            //first col
            if(vis[i][0]==0 && board[i][0]=='O')
            {
                dfs(i,0,vis,board);
            }
            //last col
            if(vis[i][m-1]==0 && board[i][m-1]=='O')
            {
                dfs(i,m-1,vis,board);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]!=1 && board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
}