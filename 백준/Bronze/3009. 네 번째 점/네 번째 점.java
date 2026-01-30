import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int[] x = new int[1001];
        x[x1]++;
        x[x2]++;
        x[x3]++;

        int[] y = new int[1001];
        y[y1]++;
        y[y2]++;
        y[y3]++;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<x.length;i++){
            if (x[i] == 1) {
                sb.append(i).append(" ");
            }
        }
        for(int i=0;i<y.length;i++){
            if (y[i] == 1) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}