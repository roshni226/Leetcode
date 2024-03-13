class Solution {
    public void rotate(int[][] matrix) {
        //intuition
        //find transpose --> find reverse
        //1. finding transpose
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix[0].length;j++)
            {
                int t=0;
                t= matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix [j][i]= t;
            }
        }
        //2. finding reverse
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length/2;j++)
            {
                int t=0;
                t=matrix[i][j];
                matrix[i][j]= matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]= t;
            }
        }
        
    }
}