package ndb.dfsbfs;

import java.util.*;
import java.io.*;

public class CitiFind{
    public static int N, M, K, X;
    public static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] d = new int[300001];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        //시작 위치 0으로 초기화
        d[X] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(X);

        while (!q.isEmpty()) {
            int now = q.poll();
            List<Integer> cities = graph.get(now);
            for (int i = 0; i < cities.size(); i++) {
                int nextCity = cities.get(i);
                if (d[nextCity] == -1) {
                    d[nextCity] = d[now] + 1;
                    q.offer(nextCity);
                }
            }
        }

        boolean check = false;

        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) System.out.println(-1);

    }
}





        /*
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

        if (!check) System.out.println(-1);*/