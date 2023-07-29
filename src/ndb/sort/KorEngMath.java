package ndb.sort;

import java.io.*;
import java.util.*;

public class KorEngMath {

    public static class Student {
        String name;
        int korean;
        int english;
        int math;
        Student(String n, int k, int e, int m){
            name = n;
            korean = k;
            english = e;
            math = m;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            students.add(new Student(
                    st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }

        students.sort((o1, o2) -> {
            if (o1.korean == o2.korean) {
                if (o1.english == o2.english) {
                    if (o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.english - o2.english;
            }
           return o2.korean - o1.korean;
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.name+"\n");
        }
        System.out.println(sb);

    }
}
