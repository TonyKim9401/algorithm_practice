package ndb.dfsbfs;

import java.util.*;
import java.io.*;

public class InsertOperator {

    public static int N;
    public static List<Integer> nums = new ArrayList<>();
    public static int add,sub,mul,div;
    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{

        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        dfs(1, nums.get(0));

        System.out.println(maxValue);
        System.out.println(minValue);

    }

    public static void dfs(int count, int now){

        if (count == nums.size()) {
            maxValue = Math.max(maxValue, now);
            minValue = Math.min(minValue, now);
        } else {
            if (add > 0) {
                add -= 1;
                dfs(count + 1, now + nums.get(count));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(count + 1, now - nums.get(count));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(count + 1, now * nums.get(count));
                mul += 1;
            }
            if (div > 0) {
                div -= 1;
                dfs(count + 1, now / nums.get(count));
                div += 1;
            }
        }

    }
}
