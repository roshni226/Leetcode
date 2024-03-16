import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        //sort
        //Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(intervals,new Comparator<int []>(){
            public int compare(int a[], int b[])
            {
                return a[0]-b[0];
            }
        });
        List<int []> ans= new ArrayList<>();
        int curr[]= intervals[0];
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]<=curr[1])
            {
                curr[1]=(int)Math.max(curr[1],intervals[i][1]);
            }
            else
            {
                ans.add(curr);
                curr=intervals[i];
            }
        }
        ans.add(curr);
        
        int res[][] = new int [ans.size()][2];
        for(int i=0;i<ans.size();i++)
        {
            res[i]= ans.get(i);
        }
        return res;
    }
}