class Solution {
    public int maxDepth(String s) {
        int curr_depth=0;
        int max_depth=0;
        int n= s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                curr_depth+=1;
            }
            else if(s.charAt(i)==')')
            {
                curr_depth-=1;
            }
            max_depth=Math.max(max_depth,curr_depth);
        }
        return max_depth;
    }
}