import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] grid = new int[m][n];

      for (int i = 0; i < grid.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < grid[0].length; j++) {
            grid[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      int ans = 0;
        
        for(int i =0; i < grid.length; i++)
        {
            for(int j =0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 0)
                {
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void dfs(int r, int c, int[][] arr)
    {
        if(arr[r][c] != 0) return;
        arr[r][c] = 1;
        
        if(r+1 < arr.length)
            dfs(r+1, c , arr);
        if(c+1 < arr[0].length)
            dfs(r, c+1 , arr);
        if(r-1 >=0)
            dfs(r-1, c , arr);
        if(c-1 >= 0)
            dfs(r, c-1 , arr);
    }

}
