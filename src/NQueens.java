import java.util.ArrayList;
import java.util.List;


public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		char[] boardRow = new char[n];
		for(int i = 0; i < n; i++)
			boardRow[i] = '.';
		List<List<String>> result = new ArrayList<List<String>>();
		backtrack(new boolean[n][n], boardRow, n, 0, -2, -2, null, result);
        return result;
    }
	public void backtrack(boolean[][] board, char[] boardRow, int n, int rowIdx, int lastX, int lastY, List<String> chessboard, List<List<String>> result){
		if(rowIdx == n){
			result.add(chessboard);
			return;
		}
		for(int i = 0; i < n; i++){
			if(!board[rowIdx][i]){
				StringBuilder sb = new StringBuilder();
				sb.append(boardRow);
				sb.replace(i, i + 1, "Q");
				List<String> newChessBoard = new ArrayList<String>();
				if(chessboard != null)
					newChessBoard.addAll(chessboard);
				newChessBoard.add(sb.toString());
				boolean[][] newBoard = board.clone();
				for(int j = 0; j < board.length; j++)
					newBoard[j] = board[j].clone();
				setBoard(rowIdx, i, newBoard, n);
				backtrack(newBoard, boardRow, n, rowIdx + 1, rowIdx, i, newChessBoard, result);
			}
		}
	}
	public void setBoard(int x, int y, boolean[][] board, int edge){
		if(x < edge){
			int row = x;
			int y1, y2;
			y1 = y2 = y;
			while(row < edge){
				board[row][y] = true;
				if(y1 >= 0)
					board[row][y1] = true;
				if(y2 < edge)
					board[row][y2] = true;
				y1--;
				y2++;
				row++;
			}
		}
	}
}
