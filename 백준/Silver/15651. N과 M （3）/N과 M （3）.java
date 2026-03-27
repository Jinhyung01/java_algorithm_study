import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        output = new int[M];
        rePermu(0);
        System.out.print(sb);
    }

    private static void rePermu(int depth) {
        if (depth == M) {
            for (int n : output) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
           output[depth] = i;
           rePermu(depth + 1);
        }
    }
}