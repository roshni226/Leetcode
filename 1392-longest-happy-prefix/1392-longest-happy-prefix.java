//we use KMP algorithm to find the longest matching prefix and suffix
//Find the LPS array and then return the value at the last index
//That will be the length of the longest suffix that matches the prefix.
import java.util.*;
class Solution {
    public String longestPrefix(String s) {
        int n= s.length();
        char arr[]= s.toCharArray();
        int lps[]= new int[n];
        lps[0]=0;
        int i=1,j=0;
        //i-> iterating the string, j->to find the length of the prefix
        while(i<n)
        {
            if(arr[i]==arr[j])
            {
                lps[i++]=++j;
            }
            else
            {
                if(j!=0)
                {
                    j= lps[j-1];
                }
                else// tricky dont forget this case
                {
                    lps[i++]=0;
                }
            }
        }
        return s.substring(0,lps[n-1]);
    }
}