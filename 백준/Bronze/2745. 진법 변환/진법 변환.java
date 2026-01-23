import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        long result = 0;
        int num = 0;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                num = c - 'A' + 10;
            } else
                num = c - '0';

            result = result * B + num;
        }
        System.out.println(result);
    }
}