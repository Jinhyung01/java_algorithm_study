import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double sum = 0;
        double sumHak = 0.0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double hak = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) {
                continue;
            }
            double score;

            if (grade.equals("A+")) {
                score = 4.5;
            } else if (grade.equals("A0")) {
                score = 4.0;
            } else if (grade.equals("B+")) {
                score = 3.5;
            } else if (grade.equals("B0")) {
                score = 3.0;
            } else if (grade.equals("C+")) {
                score = 2.5;
            } else if (grade.equals("C0")) {
                score = 2.0;
            } else if (grade.equals("D+")) {
                score = 1.5;
            } else if (grade.equals("D0")) {
                score = 1.0;
            } else {
                score = 0.0;
            }
            sum += hak * score;
            sumHak += hak;
        }
        System.out.printf("%.6f", sum / sumHak);
    }
}
