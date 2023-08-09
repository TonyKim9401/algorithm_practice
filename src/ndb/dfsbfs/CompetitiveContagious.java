package ndb.dfsbfs;

import java.util.*;
import java.io.*;

public class CompetitiveContagious {

    public static int[][] arr;
    public static int[] d = new int[]{-1, 1, -1, 1};
    public static int n;
    public static int[][] karr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        karr = new int[k+1][2];
        for (int i = 0; i <= k; i++) {
            karr[i] = new int[]{0,0};
        }
        arr = new int[n][n];
        int nums = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                // k의 좌표 기억
                if (arr[i][j] == nums) {
                    karr[nums] = new int[]{i,j};
                    nums += 1;
                }
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // s초 동안 실행
        for (int i = 1; i <= s; i++) {
            // 1 ~ k 숫자 까지 순차대로 실행
            for (int j = 1; j <= k; j++) {
                contagious(j, i);
            }
        }

        int result = arr[x - 1][y - 1];
        System.out.println(result);

    }

    // arr 에서 num에 해당 s값 늘리기
    public static void contagious(int num, int s) {

        boolean b = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == num) {
                    int[] pos = karr[num];
                    for (int n = 1; n <= 4; n++) {
                        moveTest(pos[0], pos[1], num, n); // 상,하,좌,우 퍼트리기
                    }
                    b = true;
                    break;
                }
            }
            if (b) break;
        }
    }

    public static void moveTest(int i, int j, int num, int count) {
        // 상
        int moveX;
        int moveY;
        if (count % 4 == 1) {
            moveX = j;
            moveY = i + d[0];
            // 범위 벗어나면 continue;
            if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) return;
            // 다음칸의 값이 0이 아니면 continue;
            if (arr[moveY][moveX] != 0) return;
            arr[moveY][moveX] = num;
        } else if (count % 4 == 2) {
            // 하
            moveX = j;
            moveY = i + d[1];
            if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) return;
            if (arr[moveY][moveX] != 0) return;
            arr[moveY][moveX] = num;
        } else if (count % 4 == 3) {
            // 좌
            moveX = j + d[2];
            moveY = i;
            if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) return;
            if (arr[moveY][moveX] != 0) return;
            arr[moveY][moveX] = num;
        } else {
            // 우
            moveX = j + d[3];
            moveY = i;
            if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n) return;
            if (arr[moveY][moveX] != 0) return;
            arr[moveY][moveX] = num;
        }
        karr[num] = new int[]{moveX, moveY};
    }
}