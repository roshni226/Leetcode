// class Solution {
//    public boolean isSafe(char[][] board, int row, int col, int number) {
//        //column
//        for(int i=0; i<board.length; i++) {
//            if(board[i][col] == (char)(number+'0')) {
//                return false;
//            }
//        }
      
//        //row
//        for(int j=0; j<board.length; j++) {
//            if(board[row][j] == (char)(number+'0')) {
//                return false;
//            }
//        }
      
//        //grid
//        int sr = 3 * (row/3);
//        int sc = 3 * (col/3);
      
//        for(int i=sr; i<sr+3; i++) {
//            for(int j=sc; j<sc+3; j++) {
//                if(board[i][j] == (char)(number+'0')) {
//                    return false;
//                }
//            }
//        }
//     return true;
//    }
  
//    public boolean helper(char[][] board, int row, int col) {
//        if(row == board.length) {
//            return true;
//        }
      
//        int nrow = 0;
//        int ncol = 0;
      
//        if(col == board.length-1) {
//            nrow = row + 1;
//            ncol = 0;
//        } else {
//            nrow = row;
//            ncol = col + 1;
//        }
      
//        if(board[row][col] != '.') {
//            if(helper(board, nrow, ncol)) {
//                return true;
//            }
//        } else {
          
//            //fill the place
//            for(int i=1; i<=9; i++) {
//                if(isSafe(board, row, col, i)) {
//                    board[row][col] = (char)(i+'0');
//                    if(helper(board, nrow, ncol))
//                        return true;
//                    else
//                         board[row][col] = '.';
//                }
//            }
//        }
                     
//        return false;
//    }
  
//    public void solveSudoku(char[][] board) {
//        helper(board, 0, 0);
//    }
// }


class Solution {
    public boolean isSafe(char [][] board,int row,int col,int num)
    {
        //row
        for(int i=0;i<board[0].length;i++)
        {
            if(board[row][i]==(char)(num+'0'))
            {
                return false;
            }
        }
        
        //col
        for(int i=0;i<board.length;i++)
        {
            if(board[i][col]==(char)(num+'0'))
            {
                return false;
            }
        }
        
        //grid starting pt(sr,sc)
        int sr= 3*(row/3);
        int sc= 3*(col/3);
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(board[i][j]==(char)(num+'0'))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
    public boolean helper(char [][] board,int row, int col)
    {
        if(row==board.length)
        {
           return true; 
        }
        
        //calculating row and col for next call
        int nrow, ncol;
        if(col==board[0].length-1)
        {
            nrow=row+1;
            ncol=0;
        }
        else
        {
            nrow=row;
            ncol=col+1;
        }
        //if a num is already present move to next call
        if(board[row][col]!='.')
        {
            if(helper(board,nrow,ncol))
                   return true;
        }
        else{
        //if empty cell
            for(int i=1;i<=9;i++)//checking for 1-9 numbers
            {
                if(isSafe(board,row,col,i))
                {
                    board[row][col]=(char)(i+'0');
                    if(helper(board,nrow,ncol))
                    {
                        return true;
                    }
                    else
                        board[row][col]='.';//backtrack
                    }
            }
        
        }    
        return false;
}
    public void solveSudoku(char[][] board) {
        helper(board,0,0);        
    }
}