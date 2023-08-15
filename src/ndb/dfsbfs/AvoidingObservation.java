package ndb.dfsbfs;

import java.util.*;
import java.io.*;

public class AvoidingObservation {

    public static class Teacher {
        int x;
        int y;
        boolean check;
        Teacher(int x, int y, boolean check) {
            this.x = x;
            this.y = y;
            this.check = check;
        }
    }
    public static List<Teacher> teachers = new ArrayList<>();
    public static List<Teacher> answers = new ArrayList<>();
    public static int N;
    public static String[][] arr;
    public static int[][] d = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public static boolean answer = true;
    public static Queue<Teacher> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new String[6][6];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = st.nextToken();
                if (arr[i][j].equals("T")) teachers.add(new Teacher(i, j, true));
            }
        }

        for (int i = 0; i < teachers.size(); i++) {
            q.offer(teachers.get(i));
        }

        dfs(0);

        for (Teacher teacher : answers) {
            if (!teacher.check) {
                System.out.println("NO");
                answer = false;
                break;
            }
        }

        if (answer) System.out.println("YES");
    }

    public static boolean moveToUp(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (arr[x][y].equals("O")) {
                return true;
            } else if (arr[x][y].equals("S")) {
                return false;
            } else { // T이거 X면 그대로 진행
                moveToUp(x, y - 1);
            }
        }
        return true;
    }
    public static boolean moveToDown(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (arr[x][y].equals("O")) {
                return true;
            } else if (arr[x][y].equals("S")) {
                return false;
            } else { // T이거 X면 그대로 진행
                moveToUp(x, y + 1);
            }
        }
        return true;
    }
    public static boolean moveToLeft(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (arr[x][y].equals("O")) {
                return true;
            } else if (arr[x][y].equals("S")) {
                return false;
            } else { // T이거 X면 그대로 진행
                moveToUp(x - 1, y);
            }
        }
        return true;
    }
    public static boolean moveToRight(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (arr[x][y].equals("O")) {
                return true;
            } else if (arr[x][y].equals("S")) {
                return false;
            } else { // T이거 X면 그대로 진행
                moveToUp(x + 1, y);
            }
        }
        return true;
    }
    public static void dfs(int count) {

        if (count == 3 ){
            while (!q.isEmpty()) {
                Teacher t = q.poll();

                // 상,하,좌,우 쭉 치고 나가야함
                boolean up = moveToUp(t.x, t.y - 1);
                boolean down = moveToDown(t.x, t.y + 1);
                boolean left = moveToLeft(t.x - 1, t.y);
                boolean right = moveToRight(t.x + 1, t.y);
                if (up || down || left || right) {
                    answers.add(new Teacher(t.x, t.y, false));
                } else {
                    answers.add(new Teacher(t.x, t.y, true));
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j].equals("X")) {
                        count += 1;
                        arr[i][j] = "O";
                        dfs(count);
                        arr[i][j] = "X";
                        count -= 1;
                    }
                }
            }
        }

    }
}
