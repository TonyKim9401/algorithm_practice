import java.util.Scanner;

public class ExceptThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String test = sc.next();
        int num = 0;
        for(int i=0; i<test.length(); i++){
            int index = Integer.parseInt(String.valueOf(test.charAt(i)));
            if(index > 3) index -= 1;
            num = (num * 10) + index;
        }
        int res = Integer.parseInt(String.valueOf(num),9);
        System.out.println(res);

    }

}
