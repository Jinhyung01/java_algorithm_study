import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Pizza[] pizza = new Pizza[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                pizza[i - 1] = new Pizza(i, Integer.parseInt(st.nextToken()));
            }
            Queue<Pizza> q = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                q.offer(pizza[i]);
            }
            int cur = N;
            while (q.size() != 1) {
                Pizza curPizza = q.poll();
                curPizza.cheese /= 2;
                if (curPizza.cheese != 0) {
                    q.offer(curPizza);
                } else if (cur < M) {
                    q.offer(pizza[cur]);
                    cur++;
                }

            }
            sb.append("#").append(t).append(" ").append(q.poll().num).append("\n");
        }
        System.out.println(sb);
    }

    public static class Pizza {
        int num;
        int cheese;

        public Pizza(int num, int cheese) {
            this.num = num;
            this.cheese = cheese;
        }
    }
}
