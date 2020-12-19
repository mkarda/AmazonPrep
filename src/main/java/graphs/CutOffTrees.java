package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTrees {

    //go through all that are not 0
    //cut (go) from smallest to highest

    public static void main(String[] args) {

    }

    public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int R = forest.size(), C = forest.get(0).size();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc, 0});
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tr && cur[1] == tc) return cur[2];
            for (int di = 0; di < 4; ++di) {
                int r = cur[0] + dr[di];
                int c = cur[1] + dc[di];
                if (0 <= r && r < R && 0 <= c && c < C &&
                        !seen[r][c] && forest.get(r).get(c) > 0) {
                    seen[r][c] = true;
                    queue.add(new int[]{r, c, cur[2]+1});
                }
            }
        }
        return -1;
    }
}
