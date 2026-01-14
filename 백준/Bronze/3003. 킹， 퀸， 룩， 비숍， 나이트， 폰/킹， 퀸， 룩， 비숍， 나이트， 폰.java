import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (i <= 1)
                sb.append(1 - n).append(" ");
            else if (i <= 4)
                sb.append(2 - n).append(" ");
            else
                sb.append(8 - n);
        }
        System.out.print(sb);
    }
}
