class Solution {
      // Function to Reverse the array
      public void Reverse(int[] arr, int start, int end) {
        while (start < end) {
          int temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          start++;
          end--;
        }
      }
      
      public void rotate(int[] arr, int K) {
        int n = arr.length;
        // Ensure k is within the bounds of the array length
        int k = K % n;
        // Edge cases: no rotation needed if k == 0, n == 1, or n == 0
        if (n <= 1 || k == 0) return;
        
        // Step 1: Reverse the first n-k elements
        Reverse(arr, 0, n - k - 1);
        
        // Step 2: Reverse the last k elements
        Reverse(arr, n - k, n - 1);
        
        // Step 3: Reverse the whole array
        Reverse(arr, 0, n - 1);
    }
}