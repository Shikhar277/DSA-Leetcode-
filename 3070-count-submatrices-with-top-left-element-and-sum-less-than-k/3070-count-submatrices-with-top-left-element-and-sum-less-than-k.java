class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        // turn the grid into a prefix sum grid
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               if(i>0 && j>0)
                grid[i][j] = grid[i-1][j] + grid[i][j-1] + grid[i][j] - grid[i-1][j-1];
               else if(i==0 && j>0)
                grid[i][j] = grid[i][j] + grid[i][j-1];
               else if(j==0 && i>0)
                grid[i][j] = grid[i][j] + grid[i-1][j];
            }
        }
         for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]<=k)
                count++;
            }
        }
        return count;
    }
}