class Solution {
public:

    bool isSafe(vector<vector<char>>& board, int row, int col, char dig){
        //horizontal -> check for same row/ diff columns
        for(int j=0; j<9; j++){
            if(board[row][j] == dig){
                return false;
            }
        }

        //vertical -> check for same column/diff rows
        for(int i=0; i<9; i++){
            if(board[i][col] == dig){
                return false;
            }
        }

        //grid -> 3x3
        int srow = (row/3)*3; //starting row of the grid
        int scol = (col/3)*3;  //starting col of the grid

        for(int i=srow; i<=srow+2; i++){
            for(int j=scol; j<=scol+2; j++){
                if(board[i][j] == dig){
                    return false;
                }
            }
        }
        return true;
    }

    bool helper(vector<vector<char>>& board, int row, int col){
        //base case
        if(row == 9) return true;

        int nextRow = row, nextCol = col+1;

        //if reched the end of the row, move to another row
        if(nextCol == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        //the cell is not empty -> call for the next cell
        if(board[row][col] != '.'){
            return helper(board, nextRow, nextCol);
        }

        //if the cell is empty -> place a digit
        for(char dig='1'; dig<='9'; dig++){
            if(isSafe(board,row,col,dig)){
                board[row][col] = dig;

                // Recursive call to solve rest of the board
                if(helper(board, nextRow, nextCol)){
                    return true;
                }

                board[row][col] = '.';
            }
        }
        return false; //if didn't get the answer
    }


    void solveSudoku(vector<vector<char>>& board) {
        helper(board,0,0);
    }
};