package ndb.dfsbfs;

import java.util.*;

public class IceCream {
    public static class Pos{
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        int N = 4; // y
        int M = 5; // x

        int[][] frame = new int[][]{
                {0,0,1,1,0},
                {0,1,0,1,0},
                {1,1,1,1,0},
                {0,1,1,1,0}
        };

        Pos zeroPos = getPos(N, M, frame);

        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] validate = new boolean[N][M];
        validate[zeroPos.y][zeroPos.x] = true;
        frame[zeroPos.y][zeroPos.x] = 1;
        Queue<Pos> q = new LinkedList<>();
        q.offer(zeroPos);
        int count = 1;

        while (!q.isEmpty()) {

            Pos cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int moveX = x + direction[i][1];
                int moveY = y + direction[i][0];

                if (moveX < 0 || moveX >= M || moveY < 0 || moveY >= N) continue;
                if (frame[moveY][moveX] == 1) continue;
                if (validate[moveY][moveX]) continue;

                frame[moveY][moveX] = 1;
                validate[moveY][moveX] = true;
                q.offer(new Pos(moveX,moveY));
            }
            if (q.isEmpty()) {
                Pos pos = getPos(N, M, frame);
                if (pos == null) break;
                frame[pos.y][pos.x] = 1;
                q.offer(pos);
                validate[pos.y][pos.x] = true;
                count += 1;
            }

        }

        System.out.println(count);


    }

    private static Pos getPos(int N, int M, int[][] frame) {
        boolean check = false;
        Pos zeroPos = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (frame[i][j] == 0) {
                    zeroPos = new Pos(j, i);
                    check = true;
                    break;
                }
            }
            if (check) break;
        }
        return zeroPos == null ? null : zeroPos;
    }
}
