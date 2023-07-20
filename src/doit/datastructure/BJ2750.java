package doit.datastructure;

import java.util.*;
import java.io.*;

public class BJ2750 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];


        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        br.close();

    }
}
