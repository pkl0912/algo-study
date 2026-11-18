
import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0}; 
    static int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        boolean[][][] visited = new boolean[n][m][4];

        List<Integer> answer = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                for (int d = 0; d < 4; d++) {

                    if (visited[r][c][d]) {
                        continue;
                    }

                    int count = 0;

                    int nr = r;
                    int nc = c;
                    int nd = d;

                    while (!visited[nr][nc][nd]) {

                        visited[nr][nc][nd] = true;
                        count++;

                        char current = grid[nr].charAt(nc);

                        if (current == 'L') {
                            nd = (nd + 3) % 4;
                        } else if (current == 'R') {
                            nd = (nd + 1) % 4;
                        }

                
                        nr = (nr + dr[nd] + n) % n;
                        nc = (nc + dc[nd] + m) % m;
                    }

                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}