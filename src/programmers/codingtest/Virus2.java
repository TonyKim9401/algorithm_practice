package programmers.codingtest;

public class Virus2 {
    static class Solution {
        public int[][] answer;
        public boolean[][] valid;

        public int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        public int r,c,max;

        public int[][] solution(int row, int column, int max_value, int[][] q) {
            answer = new int[row][column];
            valid = new boolean[row][column];
            r = row;
            c = column;
            max = max_value;
            // 각 쿼리의 값은 좌표를 위해 -1씩 해줘야함

            for (int i = 0; i < q.length; i++) {
                valid = new boolean[row][column];
                int x = q[i][1] - 1;
                int y = q[i][0] - 1;


                if (answer[y][x] == max) {
                    valid[y][x] = true;
                    spread(y,x);
                }
                if (answer[y][x] < max) {
                    answer[y][x] += 1;
                }
            }

            return answer;
        }

        public void spread(int y, int x) {
            for (int k = 0; k < 4; k++) {
                int moveX = x + d[k][1];
                int moveY = y + d[k][0];

                // 범위 안에서만 동작
                if (moveX >= 0 && moveX < c && moveY >= 0 && moveY < r) {
                    if (answer[moveY][moveX] == max && !valid[moveY][moveX]) {
                        valid[moveY][moveX] = true;
                        spread(moveY,moveX);
                    }
                    if (answer[moveY][moveX] < max && !valid[moveY][moveX]) {
                        valid[moveY][moveX] = true;
                        answer[moveY][moveX] += 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] result = solution.solution(
                3,4,2,new int[][]{{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}}
        );

        for (int[] ints : result) {
            for (int n :ints){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
