
public class RotateImage {
	public void rotate(int[][] matrix) {
		//Afterwards, I found that transposing matrix and invertint columns are easier
        transpose(matrix);
		invertRow(matrix);
    }
//	swap every row
    public void invertRow(int[][] matrix){
		int border = matrix.length;
		for(int i = 0; i < border / 2; i++){
			//swap row (i) and row(border - 1 - i)
			int[] temp = matrix[i];
			matrix[i] = matrix[border - 1 - i];
			matrix[border - 1 - i] = temp;
		}
	}
//  transpose matrix by another symmetry axis( (n,0) -> (0,n) )
	public void transpose(int[][] matrix){
		int border = matrix.length;
		for(int i = 0; i < border; i++){
			for(int j = 0; j < border - i - 1; j++){
				//swap (i, j) and (border - 1 - j, border - 1 -i)
				int temp = matrix[i][j];
				matrix[i][j] = matrix[border - 1 - j][border - 1 - i];
				matrix[border - 1 - j][border - 1 - i] = temp;
			}
		}
	}
}
