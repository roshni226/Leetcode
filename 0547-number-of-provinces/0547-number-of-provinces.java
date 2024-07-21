class Solution {
    public void dfs(int []vis, int node, ArrayList<ArrayList<Integer>> adj)
    {
        vis[node]=1;
        for(int i: adj.get(node))
        {
            if(vis[i]==0)
            {
                dfs(vis,i,adj);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        //Converting adjacency matrix to adjacency list
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;        
        int vis[]= new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                count++;
                dfs(vis,i,adj);
            }
            
        }
        return count;
    }
}