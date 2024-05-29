import java.util.*;
class Solution {
    public int findLongestChain(int[][] pairs) {
        int n= pairs.length;
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chainlen=1;
        int currend=pairs[0][1];
        for(int i=1;i<n;i++)
        {
            if(pairs[i][0]> currend)
            {
                chainlen++;
                currend= pairs[i][1];
            }
        }
        return chainlen;
    }
}