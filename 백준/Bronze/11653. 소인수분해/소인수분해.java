import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int i = 2;
        while (N > 1) {
            if (N % i == 0) {
                sb.append(i).append("\n");
                N /= i;
            } else {
                i++;
            }
        }
        System.out.println(sb);

    }
}