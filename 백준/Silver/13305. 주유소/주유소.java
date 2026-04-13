import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] l = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        int[] wonPerL = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wonPerL[i] = Integer.parseInt(st.nextToken());
        }

        int min = wonPerL[0];
        long result = 0;
        for (int i = 0; i < N - 1; i++) {
            if (min > wonPerL[i]) {
                min = wonPerL[i];
            }
            result += ((long)min * l[i]);
        }
        System.out.println(result);
    }
}