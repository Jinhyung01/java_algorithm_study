import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    static int[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        rePermutation(0);
        System.out.print(sb);
    }

    private static void rePermutation(int depth){
        if(depth==M){
            for(int n : output){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }
        int last_value = 0;
        for(int i=0;i<N;i++){
            if(last_value==nums[i]){
                continue;
            }
            last_value = nums[i];
            output[depth]= last_value;
            rePermutation(depth+1);
        }
    }
}