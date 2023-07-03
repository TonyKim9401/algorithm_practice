package doit.datastructure;

import java.util.*;
import java.io.*;

public class BJ11286 {
    public static void main(String[] args) throws IOException{

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);

            if (absX > absY) return absX - absY; // 절대값에 따라 내림차순
            else if (absX == absY) return x > y ? 1 : -1; // 절대값이 같다면 실제 비교후 내림차순
            else return -1; // 절대값이 작다면 내림차순
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if(queue.isEmpty()){
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(num);
            }
            System.out.print("queue : ");
            for(Integer qnum : queue){
                System.out.print(qnum + " ");
            }
        }

    }
}
