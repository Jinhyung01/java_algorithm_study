import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        int[] coins = {25, 10, 5, 1};
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            for (int j = 0; j < coins.length; j++) {
                int cnt = c / coins[j];
                if (j > 0)
                    sb.append(" ");
                sb.append(cnt);
                c %= coins[j];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}