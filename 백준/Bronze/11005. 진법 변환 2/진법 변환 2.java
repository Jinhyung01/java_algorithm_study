import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (N>0) {
            int remainder = N % B;

            if (remainder >= 10) {
                sb.append((char) (remainder - 10 + 'A'));
            } else {
                sb.append(remainder);
            }
            N = N / B;
        }
        System.out.println(sb.reverse());
    }
}