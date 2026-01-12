import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[201];
        int v = Integer.parseInt(br.readLine());

        while (st.hasMoreTokens()) {
            arr[Integer.parseInt(st.nextToken()) + 100]++;
        }

        System.out.print(arr[v + 100]);
    }
}