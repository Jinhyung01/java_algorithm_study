import java.util.Scanner;


class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            long result = pow(N, M);
            System.out.printf("#%d %d\n",T,result);
        }
    }

    public static long pow(long N, long M) {
        if (M == 1) {
            return N;
        }
        return N * pow(N, M - 1);
    }

}