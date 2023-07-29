package ndb.sort;

import java.util.*;
import java.io.*;

public class Antenna {

    public static class Ante {
        int idx;
        int distance;
        Ante(int i, int d){
            idx = i;
            distance = d;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 안테나 위치 입력받고
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //  오름차순으로 정렬
        Arrays.sort(arr);

        List<Ante> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int total = 0;
            for (int j = 0; j < arr.length; j++) {
                total += Math.abs(arr[j] - arr[i]);
            }
            list.add(new Ante(arr[i], total));
        }

        list.sort((o1, o2) -> {
            if (o1.distance == o2.distance) {
                return o1.idx - o2.idx;
            }
            return o1.distance - o2.distance;
        });

        System.out.println(list.get(0).idx);
    }
}
