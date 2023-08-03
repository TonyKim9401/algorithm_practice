package programmers.codingtest;

import java.util.*;

public class GameMapShortestDistance {
    static public class Pos{
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Solution {
        public int solution(int[][] maps) {
            int answer = 0;

            int xMax = maps[0].length;
            int yMax = maps.length;

            //                               x   y
            int[][] direction = new int[][]{{0, -1},{0, 1},{-1 ,0},{1, 0}};

            // 첫 좌표 위치는 1부터 시작
            int[][] passed = new int[yMax][xMax];
            passed[0][0] = 1;
            // 첫 좌표는 이미 지남 = true / 안지남 = false
            boolean[][] validate = new boolean[yMax][xMax];
            validate[0][0] = true;

            // 최초 좌표 위치는 0,0 왼쪽 위부터 시작 -> 오른쪽 아래 좌표의 끝으로 이동해야함
            Queue<Pos> q = new LinkedList<>();
            q.offer(new Pos(0,0));


            while (!q.isEmpty()){
                Pos nowPos = q.poll();
                int x = nowPos.x;
                int y = nowPos.y;
                int stepCount = passed[y][x];

                for (int i = 0; i < 4; i++) {
                    int moveX = x + direction[i][0];
                    int moveY = y + direction[i][1];
                    if (moveX < 0 || moveX >= xMax || moveY < 0 || moveY >= yMax) continue; // 좌표에서 벗어나면 패스
                    if (maps[moveY][moveX] == 0) continue; //벽 만나면 패스
                    if (validate[moveY][moveX]) continue; // 이미 지나온길이면 패스
                    passed[moveY][moveX] = stepCount + 1;
                    validate[moveY][moveX] = true;
                    q.offer(new Pos(moveX, moveY));
                }
            }

            answer = passed[yMax - 1][xMax - 1];
            return answer == 0 ? -1 : answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(
                new int[][] {
                        {1,0,1,1,1},
                        {1,0,1,0,1},
                        {1,0,1,1,1},
                        {1,1,1,0,1},
                        {0,0,0,0,1}
                }
        );
        System.out.println(result);
    }
}
