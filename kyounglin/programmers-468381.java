class Solution {

    int n, m;
    int answer = 0;

    int[][] placed;

    int total;

    public int solution(int[][] grid) {

        n = grid.length;
        m = grid[0].length;

        int[][] board = new int[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                board[i][j] = -1;
            }
        }

        placed = new int[n + 2][m + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                board[i + 1][j + 1] = grid[i][j];

                if (grid[i][j] == 3) {
                    total += 2;
                } else if (grid[i][j] > 0) {
                    total++;
                }
            }
        }


        dfs(board, 1, 1, 1, 1);

        return answer;
    }


    void dfs(
            int[][] board,
            int dir,
            int x,
            int y,
            int count
    ) {

        if (board[x][y] == -1) {
            return;
        }

        if (x == n && y == m) {

            if (count == total) {

                if (dir == 1 && board[x][y] == 1) {
                    answer++;
                }

                else if (dir == 2 && board[x][y] == 2) {
                    answer++;
                }
            }

            return;
        }

        int current = board[x][y];

        if (dir == 1) {

            if (current == 1 || current == 3) {

                dfs(board, 1, x, y + 1, count + 1);
            }


            else if (current == 4) {

                dfs(board, 4, x - 1, y, count + 1);
            }


            else if (current == 7) {

                dfs(board, 2, x + 1, y, count + 1);
            }


            else if (current == 0) {

                if (placed[x][y] == 3) {

                    dfs(board, 1, x, y + 1, count);
                }

                else if (placed[x][y] == 0) {

                    placed[x][y] = 3;
                    dfs(board, 1, x, y + 1, count);

                    placed[x][y] = 4;
                    dfs(board, 4, x - 1, y, count);

                    placed[x][y] = 7;
                    dfs(board, 2, x + 1, y, count);

                    placed[x][y] = 0;
                }
            }
        }

        else if (dir == 2) {

            if (current == 2 || current == 3) {

                dfs(board, 2, x + 1, y, count + 1);
            }

            else if (current == 4) {

                dfs(board, 3, x, y - 1, count + 1);
            }

            else if (current == 5) {

                dfs(board, 1, x, y + 1, count + 1);
            }

            else if (current == 0) {

                if (placed[x][y] == 3) {

                    dfs(board, 2, x + 1, y, count);
                }

                else if (placed[x][y] == 0) {

                    placed[x][y] = 3;
                    dfs(board, 2, x + 1, y, count);

                    placed[x][y] = 4;
                    dfs(board, 3, x, y - 1, count);

                    placed[x][y] = 5;
                    dfs(board, 1, x, y + 1, count);

                    placed[x][y] = 0;
                }
            }
        }

        else if (dir == 3) {

            if (current == 1 || current == 3) {

                dfs(board, 3, x, y - 1, count + 1);
            }

            else if (current == 5) {

                dfs(board, 4, x - 1, y, count + 1);
            }

            else if (current == 6) {

                dfs(board, 2, x + 1, y, count + 1);
            }

            // 빈칸
            else if (current == 0) {

                if (placed[x][y] == 3) {

                    dfs(board, 3, x, y - 1, count);
                }

                else if (placed[x][y] == 0) {

                    placed[x][y] = 3;
                    dfs(board, 3, x, y - 1, count);

                    placed[x][y] = 5;
                    dfs(board, 4, x - 1, y, count);

                    placed[x][y] = 6;
                    dfs(board, 2, x + 1, y, count);

                    placed[x][y] = 0;
                }
            }
        }

        else {

            if (current == 2 || current == 3) {

                dfs(board, 4, x - 1, y, count + 1);
            }

            else if (current == 6) {

                dfs(board, 1, x, y + 1, count + 1);
            }

            else if (current == 7) {

                dfs(board, 3, x, y - 1, count + 1);
            }

            else if (current == 0) {

                if (placed[x][y] == 3) {

                    dfs(board, 4, x - 1, y, count);
                }

                else if (placed[x][y] == 0) {

                    placed[x][y] = 3;
                    dfs(board, 4, x - 1, y, count);

                    placed[x][y] = 6;
                    dfs(board, 1, x, y + 1, count);

                    placed[x][y] = 7;
                    dfs(board, 3, x, y - 1, count);

                    placed[x][y] = 0;
                }
            }
        }
    }
}