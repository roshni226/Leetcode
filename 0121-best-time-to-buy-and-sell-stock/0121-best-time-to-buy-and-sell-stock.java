import java.util.*;
import java.io.*;
class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int maxProfit= 0;
        int minPrice= Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            minPrice= (int)Math.min(minPrice,prices[i]);
            maxProfit=(int) Math.max(maxProfit,prices[i]- minPrice);
        }
        return maxProfit;
    }
}