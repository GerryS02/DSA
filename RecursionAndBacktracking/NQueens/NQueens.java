package DSA.RecursionAndBacktracking.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static class Solution{
        public boolean isSafe(List<String> board, int row, int col, int n){
            // check horizontal
            for(int j=0; j<n; j++){
                if(board.get(row).charAt(j) == 'Q'){
                    return false;
                }
            }

            // check vertical
            for(int i=0; i<n; i++){
                if(board.get(i).charAt(col) == 'Q'){
                    return false;
                }
            }

            // check at left diagonal
            for(int i=row, j=col; i>=0 && j>=0; i--, j--){
                if(board.get(i).charAt(j) == 'Q'){
                    return false;
                }
            }

            // check at right diagonal
            for(int i=row, j=col; i>=0 && j<n; i--, j++){
                if(board.get(i).charAt(j) == 'Q'){
                    return false;
                }
            }

            return true;
        }
        
        public void nQueens(List<String> board, int row, int n, List<List<String>> ans){

            if(row == n){
                ans.add(new ArrayList<>(board));
                return;
            }

            for(int j=0; j<n; j++){
                if(isSafe(board, row, j, n)){
                    char[] rowChar = board.get(row).toCharArray(); // convert row to char array
                    rowChar[j] = 'Q'; // place the queen
                    board.set(row, new String(rowChar)); //update the board with new row

                    nQueens(board, row+1, n, ans);

                    // backtracking
                    rowChar[j] = '.';
                    board.set(row, new String(rowChar)); // update after backtracking
                }
            }
        }
        
        public List<List<String>> solveNQueens(int n){
            List<String> board = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();

            //intitalize an empty board
            for(int i=0; i<n; i++){
                char[] row = new char[n]; // create a row of characters
                Arrays.fill(row, '.'); // fill each row with '.'

                board.add(new String(row)); // convert to string and add to board
            }

            nQueens(board, 0, n, ans);
            return ans;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int n = 4; 
        List<List<String>> solutions = sol.solveNQueens(n);

        // Print the solutions
        System.out.println("Total solutions for N = " + n + ": " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println(); // Print an empty line between solutions
        }

    }
}
