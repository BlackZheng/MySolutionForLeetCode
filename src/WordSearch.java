//it's not a good solution
public class WordSearch {
	char[][] board;
	String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
		this.word = word;
		int[][] move = {{0, 1},{1, 0}, {0, -1},{-1, 0}};
		int m = board.length;
		int n = board[0].length;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				//find the first character of word
				if(board[i][j] == word.charAt(0)){
					if(dfs(new boolean[m][n], move, i, j, 1))
						return true;
				}
			}
		}
        return false;
    }
    public boolean dfs(boolean[][] flags, int[][] move, int x, int y, int idx){
		if(idx == word.length())
			return true;
		for(int i = 0; i < move.length; i++){
			int nextX = x + move[i][0];
			int nextY = y + move[i][1];
			if(nextX >= 0 && nextX < board.length && nextY >= 0 
					&& nextY < board[0].length && !flags[nextX][nextY] 
							&& board[nextX][nextY] == word.charAt(idx)){
				boolean[][] newFlags = new boolean[flags.length][];
				for(int j = 0; j < flags.length; j++){
					newFlags[j] = flags[j].clone();
				}
				newFlags[x][y] = true;
				if(dfs(newFlags, move, nextX, nextY, idx + 1))
					return true;
			}
		}
		return false;
	}
}
