package doit.datastructure;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.*;

public class BJ1920 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] target = new int[Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] comp = new int[Integer.parseInt(st.nextToken())];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < comp.length; i++) {
            comp[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(target);
        for (int i = 0; i < comp.length; i++) {
            boolean check = binarySearch(target,  comp[i]);
            if (check) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean binarySearch(int[] target, int num){
        int min = 0;
        int max = target.length - 1;

        while(min <= max) {

            int mid = (min + max) / 2;

            if (target[mid] == num) {
                return true;
            } else if (target[mid] > num) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
