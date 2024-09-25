class Solution {
    //optimal 2 O(log(n*m))
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int n= matrix.length;
    //     int m= matrix[0].length;
    //     int l=0;
    //     int h=n*m-1;
    //     while(l<=h)
    //     {
    //         int mid = (l+h)/2;
    //         int midRow= mid/m, midCol= mid%m;
    //         if(matrix[midRow][midCol]==target)
    //         {
    //             return true;
    //         }
    //         else if(matrix[midRow][midCol]<target)
    //         {
    //             l=mid+1;
    //         }
    //         else
    //         {
    //             h=mid-1;
    //         }
    //     }
    //     return false;
    //}
    
    //optimal 1 - O(N)
    
    public boolean binarySearch(int []arr, int target)
    {
        int n= arr.length;
        int l=0,h=n-1;
        while(l<=h)
        {
            int mid= (l+h)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            else if(arr[mid]>target)
            {
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix[0].length;
        int n= matrix.length;
        
        for(int i=0;i<n;i++)
        {
            if(target>=matrix[i][0] && target<=matrix[i][m-1])
            {
                return binarySearch(matrix[i],target);
            }
        }
        
        return false;
    }
        
}