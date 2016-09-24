
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int start = 0;
        int end = matrix.length - 1;
        int middle;
        //search the exact row
//        while(row + 1 < matrix.length && target >= matrix[row + 1][0])
//            row++;
        
        while(start < end + 1){
        	 middle = (start + end) / 2;
        	 if(matrix[middle][0] == target)
                 return true;
        	 else if(start == end + 1){
        		 if(target > matrix[middle][0])
        			 row = middle;
        		 else
        			 row = middle + 1;
        		 break;
        	 }
        	 else if(matrix[row][0] < target)
                 start = middle;
             else if(matrix[row][0] > target)
                 end = middle;
        }
        start = 0;
        end = matrix[0].length - 1;
        //binary search in the row
        while(start <= end){
            middle = (start + end) / 2;
            if(matrix[row][middle] < target)
                start = middle + 1;
            else if(matrix[row][middle] > target)
                end = middle - 1;
            else
                return true;
        }
        return false;
    }
}
