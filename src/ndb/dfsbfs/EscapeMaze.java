package ndb.dfsbfs;

import java.util.*;

public class EscapeMaze {

    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int N = 5; // y
        int M = 6; // x

        int[][] maze = new int[][]{
                {1,0,1,0,1,0},
                {1,1,1,1,1,1},
                {0,0,0,0,0,1},
                {1,1,1,1,1,1},
                {1,1,1,1,1,1}
        };
        // 1 길 / 0 용
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        int[][] stepCount = new int[N][M];
        boolean[][] validate = new boolean[N][M];

        stepCount[0][0] = 1;
        validate[0][0] = true;

        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0,0));

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int step = stepCount[y][x];
            for (int i = 0; i < 4; i++) {
                int moveX = x + direction[i][1];
                int moveY = y + direction[i][0];

                if (moveX < 0 || moveX >= M || moveY < 0 || moveY >= N) continue;
                if (maze[moveY][moveX] == 0) continue;
                if (validate[moveY][moveX]) continue;

                stepCount[moveY][moveX] = step + 1;
                validate[moveY][moveX] = true;
                q.offer(new Pos(moveX, moveY));
            }
        }

        int result = stepCount[N-1][M-1];
        System.out.println(result);
    }
}
