package ndb.greedy;

public class Changes {
    public static void main(String[] args) {

        int answer = 0;
        int N = 1260;

        int[] changes = new int[]{500, 100, 50, 10};

        for (int change : changes) {

            answer += N / change;
            N = N % change;

        }
        System.out.println(answer);

    }
}
