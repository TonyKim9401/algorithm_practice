package ndb.dfsbfs;

import java.util.*;

public class Laboratory {
    public static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        int N = 7;
        int M = 7;

        int[][] map = new int[][]{
                {2,0,0,0,1,1,0},
                {0,0,1,0,1,2,0},
                {0,1,1,0,1,0,0},
                {0,1,0,0,0,0,0},
                {0,0,0,0,0,1,1},
                {0,1,0,0,0,0,0},
                {0,1,0,0,0,0,0}
        };

        int walls = 3;

        // 바이러스 좌표 확인
        List<Pos> v = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; i++) {
                if (map[i][j] == 2) {
                    v.add(new Pos(j, i));
                }
            }
        }

        int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};




    }
}
