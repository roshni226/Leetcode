class Solution {
    public void bfs(int node, int[][] isConnected, int[] vis, int n)
    {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(node);
        vis[node]=1;
        while(!queue.isEmpty())
        {
            int curr= queue.poll();
            for(int j=0;j<n;j++)
            {
                if(isConnected[curr][j]==1)
                {
                    if(vis[j]==0)
                    {
                        queue.add(j);
                        vis[j]=1;
                    }
                    
                }
            }   
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int vis[]= new int[n+1];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                count++;
                bfs(i,isConnected,vis,n);
            }
        }
        return count;
    }
}