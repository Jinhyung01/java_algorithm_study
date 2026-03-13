import java.io.*;

public class Main {
    static int K = 2000001;
    static int OFFSET = 1000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];         
        int[] count = new int[K];    
        int[] result = new int[N];   
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            count[A[i] + OFFSET]++;
        }
        for (int i = 1; i < K; i++) {
            count[i] += count[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            int value = A[i];
            int index = value + OFFSET;
            
            count[index]--;
            result[count[index]] = value;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);
    }
}