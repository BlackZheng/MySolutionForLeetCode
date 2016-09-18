
public class UniquePathsII {
	//The main thought is dynamic programming
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length < 1 || obstacleGrid[0][0] == 1)//if the starting point is an obstacle, return 0
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for(int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 0)
                obstacleGrid[0][i] = 1;
            else{   // At the first row, if we encounter an obstacle, the following cells at this row can not be reached
                for(int j = i; j < n; j++){
                    obstacleGrid[0][j] = 0;
                }
                break;
            }
        }
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 0)
                obstacleGrid[i][0] = 1;
            else{	// At the first column, if we encounter an obstacle, the following cells at this column can not be reached
                for(int j = i; j < m; j++){
                    obstacleGrid[j][0] = 0;
                }
                break;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
//                if we encounter an obstacle, mark it as 0 and then we will count it after
                else
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
            }
        }
        return obstacleGrid[m - 1][n - 1];
        
    }
}
