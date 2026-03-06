import java.io.*;
import java.util.*;

public class Main {

    static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSelect(A, 0, N - 1, K);
        System.out.println(A[K]);
    }

    static void quickSelect(int[] A, int S, int E, int K) {
        if (S >= E) return;

        int pivotIndex = partition(A, S, E);

        if (pivotIndex == K) return;
        else if (pivotIndex > K)
            quickSelect(A, S, pivotIndex - 1, K);
        else
            quickSelect(A, pivotIndex + 1, E, K);
    }

    static int partition(int[] A, int S, int E) {

        int pivotIndex = S + rand.nextInt(E - S + 1);
        swap(A, S, pivotIndex);

        int pivot = A[S];
        int low = S + 1;
        int high = E;

        while (low <= high) {

            while (low <= E && A[low] < pivot) low++;
            while (high > S && A[high] > pivot) high--;

            if (low <= high) {
                swap(A, low, high);
                low++;
                high--;
            }
        }

        swap(A, S, high);
        return high;
    }

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}