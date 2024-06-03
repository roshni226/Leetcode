class Solution {
    public boolean isSafe(char [][] board, int row, int col)
    {
        //horizontally
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i]=='Q')
            {
                return false;
            }
        }
        
        //vertically
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }
        
        //upper left
        for(int i=row, j=col;i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        
        //upper right
        for(int i=row,j=col;i>=0 && j<board[0].length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        
        //lowerleft
        for(int i=row,j=col;i<board.length && j>=0;i++,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        
        //lower right
        for(int i=row,j=col;i<board.length && j<board[0].length;i++,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }
        }
        
        return true;
    }
    public void SaveBoard(char [][]board, List<List<String>> allBoards)
    {
        String row="";
        List<String> curr= new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            row="";
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='Q')
                {
                    row+="Q";
                }
                else
                {
                    row+=".";
                }
            }
            curr.add(row);
        }
        
        allBoards.add(curr);
    }
    public void helper(char [][] board,int col, List<List<String>> allBoards)
    {
        if(col==board.length)
        {
            SaveBoard(board,allBoards);
            return;
        }
        
        for(int row=0;row<board.length;row++)
        {
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                helper(board,col+1,allBoards);
                board[row][col]='.';//backtrack
            }
            
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char [][] board= new char[n][n];
        List<List<String>> allBoards= new ArrayList<>();
        helper(board,0,allBoards);
        return allBoards;
        
    }
}