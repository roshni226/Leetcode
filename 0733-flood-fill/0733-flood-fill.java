class Solution {
    public void dfs(int [][] image, int stcolor, int color, int i, int j, int n, int m)
    {
        image[i][j]=color;
        int dx[]= {0,0,1,-1};
        int dy[]= {1,-1,0,0};
        for(int k=0;k<4;k++)
        {
            int x= i+dx[k];
            int y= j+dy[k];
            if (x >= 0 && y >= 0 && x < n && y < m && image[x][y] == stcolor) {
                dfs(image, stcolor, color, x, y, n, m);
            }
            
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m= image[0].length;
        
        
        int stcolor= image[sr][sc];
        if(stcolor!=color)
        {
         dfs(image,stcolor,color,sr,sc,n,m);   
        }
        return image;
        
    }
}