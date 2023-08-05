package ndb.dfsbfs;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class CitiFind {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 구간 합
        int[] values = new int[3000001];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            graph.add(new ArrayList<>());
            values[i] = -1;
        }

        // 그래프 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }


        Queue<Integer> q = new LinkedList<>();
        values[X] = 0; // 초기화
        q.offer(X);

        while (!q.isEmpty()) {
            int city = q.poll();
            List<Integer> nextCity = graph.get(city);
            for (int i = 0; i < nextCity.size(); i++) {
                if (values[nextCity.get(i)] == -1) values[nextCity.get(i)] = values[city] + 1;
                q.offer(nextCity.get(i));
            }

        }

        boolean check = false;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] != -1 && values[i] == K) {
                result.add(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }

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