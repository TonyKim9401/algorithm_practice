package ndb.dfsbfs;

import java.util.*;

public class CitiFind {
    public static void main(String[] args) {

        int n = 4;
        int x = 1;
        int k = 2;
        int[][] maps = new int[][]{
                {}, // 0번째 없음
                {2,3},  //총 4개 인덱스
                {3,4},
                {},
                {}
        };

        int[] distance = new int[300001];

        for (int i = 0; i <= n; i++) {
            distance[i] = -1;
        }

        distance[x] = 0; //처음 출발 위치
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while (!q.isEmpty()) {
            int now= q.poll();

            for (int i = 0; i < maps[now].length; i++) {
                int nextCity = maps[now][i];
                if (distance[nextCity] == -1)  {
                    distance[nextCity] = distance[now] + 1;
                    q.offer(nextCity);
                }
            }
        }

        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);

    }
}
