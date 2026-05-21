package kyounglin;

import java.util.*;

class Solution {
    
    int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[j][n-1-i] = key[i][j];
        return result;
    }
    
    boolean check(int[][] board, int[][] key, int row, int col, int lockSize) {
        int n = key.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[row+i][col+j] += key[i][j];
        

        int offset = lockSize;
        boolean result = true;
        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (board[offset+i][offset+j] != 1) {
                    result = false;
                    break;
                }
            }
            if (!result) break;
        }
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[row+i][col+j] -= key[i][j];
        
        return result;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;
        int boardSize = lockSize * 3;
        
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < lockSize; i++)
            for (int j = 0; j < lockSize; j++)
                board[lockSize+i][lockSize+j] = lock[i][j];
        
        for (int r = 0; r < 4; r++) {
            for (int i = 0; i <= boardSize - keySize; i++) {
                for (int j = 0; j <= boardSize - keySize; j++) {
                    if (check(board, key, i, j, lockSize)) return true;
                }
            }
            key = rotate(key);
        }
        
        return false;
    }
}