import java.util.*;
import java.io.*;

public class Main {
    static Random rand = new Random();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);

    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivotIndex = partition(A, S, E);
            if (pivotIndex == K)
                return;
            else if (K < pivotIndex) {
                quickSort(A, S, pivotIndex - 1, K);
            } else {
                quickSort(A, pivotIndex + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        int pivotIndex = S+ rand.nextInt(E - S + 1);
        swap(A, S, pivotIndex);
        int pivot = A[S];

        int low = S + 1;
        int high = E;

        while (low <= high) {
            while (low <= E && A[low] < pivot) {
                low++;
            }
            while (high > S && A[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swap(A, low, high);
                low++;
                high--;
            }
        }
        swap(A, S, high);
        return high;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}