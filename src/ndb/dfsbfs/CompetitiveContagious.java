package ndb.dfsbfs;

import java.util.*;
import java.io.*;

public class CompetitiveContagious {

    public static class Virus{
        int index;
        int second;
        int x;
        int y;
        Virus(int index, int second, int x, int y) {
            this.index = index;
            this.second = second;
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] arr;
    public static int[][] d = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public static ArrayList<Virus> viruses = new ArrayList<>();
    public static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[200][200];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 ) {
                    viruses.add(new Virus(arr[i][j], 0, i, j));
                }
            }
        }

        Collections.sort(viruses, (o1, o2) -> {
            int idx1 = o1.index;
            int idx2 = o2.index;
            if (idx1 < idx2) {
                return -1;
            }
            return 1;
        });

        Queue<Virus> q = new LinkedList<>();
        for (Virus v : viruses) {
            q.offer(v);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        while (!q.isEmpty()) {
            Virus v = q.poll();

            if (v.second == s) break;

            for (int i = 0; i < 4; i++) {
                int moveX = v.x + d[i][1];
                int moveY = v.y + d[i][0];

                if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < n) {
                    if (arr[moveX][moveY] == 0) {
                        arr[moveX][moveY] = v.index;
                        q.offer(new Virus(v.index, v.second + 1, moveX, moveY));
                    }
                }
            }

        }
        System.out.println(arr[x - 1][y - 1]);
    }
}