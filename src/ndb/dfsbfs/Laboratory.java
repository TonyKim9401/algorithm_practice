package ndb.dfsbfs;

import java.util.*;
import java.io.*;

public class Laboratory {

    public static int n, m, result = 0;
    public static int[][] arr = new int[8][8];
    public static int[][] temp = new int[8][8];
    public static int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int count) {
        // 울타리가 3개 설치된 경우
        if (count == 3) {
            // 원래 배열 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            // 복사 배열에서 바이러스 진행 검사
            for (int i = 0; i < n; i++) {
                for (int j = 0;j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i,j);
                    }
                }
            }
            result = Math.max(result, getScore());
            return;
        }

        // 빈 공간에 울타리 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int moveX = x + d[i][1];
            int moveY = y + d[i][0];

            if(moveX >= 0 && moveX < n && moveY >= 0 && moveY < m) {
                if (temp[moveX][moveY] == 0) {
                    temp[moveX][moveY] = 2;
                    virus(moveX, moveY);
                }
            }
        }
    }

    public static int getScore() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) count += 1;
            }
        }
        return count;
    }
}
