package doit.datastructure;

import java.util.*;
import java.io.*;

public class BJ25305 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int people = Integer.parseInt(st.nextToken());
        int cutLine = Integer.parseInt(st.nextToken());

        Integer[] score = new Integer[people];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < people; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score, Collections.reverseOrder());
        System.out.println(score[cutLine - 1]);
    }
}
