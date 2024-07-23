class Node{
    int row;
    int col;
    int steps;
    public Node(int row, int col, int steps)
    {
        this.row= row;
        this.col= col;
        this.steps= steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;
        int vis[][]= new int[n][m];
        int dist[][]= new int[n][m];
        Queue<Node> queue= new LinkedList<Node>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=1;
                    queue.add(new Node(i,j,0));//coordinates and the step size
                }
            }
        }
        
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        
        while(!queue.isEmpty())
        {
            Node node= queue.poll();
            int r= node.row;
            int c= node.col;
            int steps= node.steps;
            dist[r][c]= steps;
            
            for(int i=0;i<4;i++)
            {
                int x= r+dx[i];
                int y= c+dy[i];
                if(x>=0 && y>=0 && x<n && y<m &&vis[x][y]==0)
                {
                    queue.add(new Node(x,y,steps+1));
                    vis[x][y]=1;
                }
            }
        }
        
        return dist;
    }
}