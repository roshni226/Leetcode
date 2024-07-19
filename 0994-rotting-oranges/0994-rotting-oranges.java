class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int rows= grid.length;
        int cols= grid[0].length;
        int total=0, count=0, minTime=0;
        //calc total oranges
        //insert indices of rotten oranges in the queue
        Queue<int []> queue= new LinkedList<>(); 
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j]!=0)
                    total++;
                if(grid[i][j]==2)
                    queue.add(new int[]{i,j});    
            }
        }
        
        // No oranges
        if(total==0)
            return 0;
        
        //for finding indices in four directions
        // up down right left
        int dx[]= {0,0,1,-1};
        int dy[]= {1,-1,0,0};
        
        //start BFS
        while(!queue.isEmpty())
        {
            int size= queue.size();
            count+=size; // used to count total number of processes
            for(int i=0;i<size;i++)
            {
                int[] point= queue.poll();
                for(int j=0;j<4;j++)
                {
                    //find out coordinates of the cell that needs to be processed
                    int x=point[0]+dx[j];
                    int y=point[1]+dy[j];
                    
                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y]==0 || grid[x][y]==2)
                    {
                        continue;
                    }
                    
                    grid[x][y]=2;
                    queue.add(new int[]{x,y});
                }
            }
            //all four directions are processed simultaneously thus
            if(queue.size()!=0)
                minTime++;         
        }
        
        if(count==total)// count is all the oranges that are being processed ie rooten oranges + fresh oranges
            return minTime;
        else
            return -1;//could not make all fresh oranges rotten
    }
}