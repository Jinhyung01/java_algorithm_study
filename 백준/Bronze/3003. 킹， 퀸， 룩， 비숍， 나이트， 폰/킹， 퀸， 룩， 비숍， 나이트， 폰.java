import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] piece = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(i>0)
                sb.append(' ');
            sb.append(piece[i] - n);
        }
        System.out.print(sb);
    }
}