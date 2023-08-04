package programmers.codingtest;

public class HowManyBrackets {

    public static class Bracket {
        int open;
        int close;
        Bracket(int x, int y) {
            this.open = x;
            this.close = y;
        }
    }

    static int count = 0;

    public static void main(String[] args) {

        int n = 3;
        dfs(1, 0, n);

        System.out.println(count);

    }

    public static void dfs(int open,int close, int n) {
        if (open > n) return;
        if (open < close) return;
        if (open == close && close == n) count += 1;
        dfs(open + 1, close, n);
        dfs(open, close +1, n);

    }
}
