package programmers;
import java.util.*;
public class Solution388353 {

    class Solution {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int solution(String[] storage, String[] requests) {

            int answer = 0;

            // map 생성
            int n = storage.length;
            int m = storage[0].length();

            char[][] map = new char[n + 2][m + 2];

            // 바깥은 모두 빈 공간
            for (int i = 0; i < n + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            // 실제 창고 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i + 1][j + 1] = storage[i].charAt(j);
                }
            }

            for (int i = 0; i < requests.length; i++) {

                String r = requests[i];
                char target = r.charAt(0);

                // 크레인
                if (r.length() == 2) {

                    for (int x = 1; x <= n; x++) {
                        for (int y = 1; y <= m; y++) {

                            if (map[x][y] == target) {
                                map[x][y] = '.';
                            }
                        }
                    }
                }

                // 지게차
                else {

                    boolean[][] outside = new boolean[n + 2][m + 2];

                    Deque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{0, 0});
                    outside[0][0] = true;

                    // 외부 공기 BFS
                    while (!q.isEmpty()) {

                        int[] current = q.poll();

                        int x = current[0];
                        int y = current[1];

                        for (int d = 0; d < 4; d++) {

                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2)
                                continue;

                            if (outside[nx][ny])
                                continue;

                            if (map[nx][ny] == '.') {
                                outside[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }

                    // 제거할 컨테이너 저장
                    List<int[]> remove = new ArrayList<>();

                    for (int x = 1; x <= n; x++) {
                        for (int y = 1; y <= m; y++) {

                            if (map[x][y] != target)
                                continue;

                            for (int d = 0; d < 4; d++) {

                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                if (outside[nx][ny]) {
                                    remove.add(new int[]{x, y});
                                    break;
                                }
                            }
                        }
                    }

                    // 한꺼번에 제거
                    for (int[] p : remove) {
                        map[p[0]][p[1]] = '.';
                    }
                }
            }

            // 남은 컨테이너 개수
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {

                    if (map[i][j] != '.') {
                        answer++;
                    }
                }
            }

            return answer;
        }
    }

}
