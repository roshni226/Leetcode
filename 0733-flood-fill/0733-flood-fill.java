class Pair{
    int r;
    int c;
    public Pair(int r, int c)
    {
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m= image[0].length;
        int vis[][]= new int[n][m];
        Queue<Pair> queue= new LinkedList<Pair>();
        queue.add(new Pair(sr,sc));
        vis[sr][sc]=1;
        int stcolor=image[sr][sc];
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        while(!queue.isEmpty())
        {
            Pair curr= queue.poll();
            int r=curr.r;
            int c= curr.c;
            image[r][c]=color;
            for(int j=0;j<4;j++)
            {
                int x= r+dx[j];
                int y= c+dy[j];
                if(x<0||y<0||x>=n||y>=m||image[x][y]!=stcolor||vis[x][y]==1)
                {
                    continue;
                }
                vis[x][y]=1;
                queue.add(new Pair(x,y));
            }
        }
        return image;
    }
}