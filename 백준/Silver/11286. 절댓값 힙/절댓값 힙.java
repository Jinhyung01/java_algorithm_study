import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    int firstAbs = Math.abs(o1);
                    int secondAbs = Math.abs(o2);

                    if (firstAbs == secondAbs) {
                        return (o1 < o2) ? -1 : 1;
                    }
                    return firstAbs - secondAbs;
                }
        );
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.offer(x);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                } else
                    sb.append("0\n");
            }
        }
        System.out.println(sb);

    }
}