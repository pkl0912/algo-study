package programmers;
import java.util.*;
public class Solution42579 {


    class Solution {
        public int[] solution(String[] genres, int[] plays) {

            // 1. 장르별 재생횟수 저장
            HashMap<String, Integer> genresCount = new HashMap<>();
            int n = genres.length;
            for (int i = 0; i < n; i++) {
                genresCount.put(genres[i], genresCount.getOrDefault(genres[i], 0) + plays[i]);
            }

            // 2. 장르별 [노래index, 재생횟수] 저장
            HashMap<String, List<int[]>> genresPlay = new HashMap<>();
            for (String k : genresCount.keySet()) {
                genresPlay.put(k, new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                genresPlay.get(genres[i]).add(new int[]{i, plays[i]});
            }

            // 3. sort
            List<String> genresKind = new ArrayList<>(genresCount.keySet());
            genresKind.sort((a, b) -> genresCount.get(b) - genresCount.get(a)); // 재생횟수 내림차순
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < genresKind.size(); i++) {
                String genre = genresKind.get(i);

                List<int[]> musics = genresPlay.get(genre);
                musics.sort((a, b) -> {
                    if (a[1] != b[1]) return b[1] - a[1]; // 재생횟수 기준 내림차순
                    return a[0] - b[0]; // index 오름차순
                });

                result.add(musics.get(0)[0]);

                if (musics.size() > 1) {
                    result.add(musics.get(1)[0]);
                }
            }

            int s = result.size();
            int[] r = new int[s];
            for (int i = 0; i < s; i++) {
                r[i] = result.get(i);
            }

            return r;
        }
    }
}
