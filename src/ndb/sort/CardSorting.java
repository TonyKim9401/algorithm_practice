package ndb.sort;

import java.util.*;
import java.io.*;

public class CardSorting {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        long sum = 0;

        while(pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            sum += temp;
            pq.add(temp);
        }

        System.out.println(sum);

    }


}
