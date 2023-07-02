package doit.datastructure;

import java.util.*;

public class BJ2164 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> original = new LinkedList<>();

        for(int i = 1; i <=N; i++) {
            original.add(i);
        }

        while(original.size() > 1) {
            original.poll();
            original.add(original.poll());
        }

        System.out.println(original.poll());

    }
}
