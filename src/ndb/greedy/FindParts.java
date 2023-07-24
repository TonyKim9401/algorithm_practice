package ndb.greedy;

import java.io.*;
import java.util.*;

public class FindParts {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] store = new int[N];
        for(int i = 0; i < N; i++) {
            store[i] = Integer.parseInt(st.nextToken());
        }

        // store 물건 한번 정렬
        Arrays.sort(store);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] customer = new int[M];
        for(int i = 0; i < M; i++) {
            customer[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customer.length; i++) {
            int num = customer[i];
            int start = 0;
            int end = store.length - 1;
            String answer = "No";

            while (start <= end) {

                int mid = (start + end) / 2;

                if (store[mid] == num) {
                    answer = "Yes";
                    break;
                } else if (store[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            sb.append(answer.equals("Yes") ? "Yes\n" : "No\n");
        }
        System.out.println(sb.toString());

    }
}
