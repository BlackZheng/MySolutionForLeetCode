
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int i;
		for(i = 1; i <= n; i++){ //fill the first row
			matrix[0][i - 1] = i;
		}
		int x, y, edge, maxStep;
		x = 0;
		y = n - 1;
		edge = n;
		maxStep = n*n;
		while(i <= maxStep){
			for(int j = 1; i <= maxStep && j <= 4; j++){
				if(j % 2 == 1)
					edge --; //when we change the direction twice, the edge must be decreased
				for(int k = 0; k < edge; k++, i++){
					switch (j) {
					case 1://step down
						x ++;
						break;
					case 2://step left
						y --;
						break;
					case 3://step up
						x --;
						break;	
					case 4://step right
						y ++;
					default:
						break;
					}
					matrix[x][y] = i;
				}
			}
		}
        return matrix;
    }
}
