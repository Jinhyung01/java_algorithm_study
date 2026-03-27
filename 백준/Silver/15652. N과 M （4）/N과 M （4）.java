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
        reCombi(0,1);
        System.out.print(sb);
    }

    private static void reCombi(int depth,int start) {
        if (depth == M) {
            for (int n : output) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
       for(int i=start; i<=N; i++) {
           output[depth] = i;
           reCombi(depth+1, i);
       }
    }
}