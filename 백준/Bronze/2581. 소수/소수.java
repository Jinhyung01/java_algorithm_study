import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[10001];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i * i < arr.length; i++) {
            if (!arr[i]) continue;

            for (int j = i * i; j < arr.length; j = j + i) {
                arr[j] = false;
            }
        }
        int sum = 0;
        int min = -1;
        for (int i = M; i <= N; i++) {
            if (arr[i]) {
                sum += i;
                if (min == -1) min = i;
            }
        }
        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else
            System.out.println(-1);
    }
}