import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            while (count[i]-- > 0) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);

    }
}