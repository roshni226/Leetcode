class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;
        int l=0;
        int h=n*m-1;
        while(l<=h)
        {
            int mid = (l+h)/2;
            int midRow= mid/m, midCol= mid%m;
            if(matrix[midRow][midCol]==target)
            {
                return true;
            }
            else if(matrix[midRow][midCol]<target)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return false;
        
    }
}