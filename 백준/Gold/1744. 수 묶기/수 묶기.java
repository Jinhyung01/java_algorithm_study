import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pos = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                pos.offer(num);
            } else if (num <= 0) {
                neg.offer(num);
            } else {
                oneCount++;
            }
        }
        int result = oneCount;

        while (pos.size() > 1) {
            int first = pos.poll();
            int second = pos.poll();
            result += first * second;
        }
        if(!pos.isEmpty()){
            result += pos.poll();
        }
        while (neg.size() > 1) {
            int first = neg.poll();
            int second = neg.poll();
            result += first * second;
        }
        if(!neg.isEmpty()){
            result += neg.poll();
        }
        System.out.println(result);

    }
}