package ndb.greedy;

import java.util.*;
import java.io.*;

public class ImpossiblePrice {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int target = 1;

        // 2, 3, 5, 8, 16, 32,
        // 1, 1, 2, 3, 8, 16

        for (int i = 0; i < N; i++) {
            if (target < list.get(i)) break;
            target += list.get(i);
        }

        System.out.println(target);
    }
}
