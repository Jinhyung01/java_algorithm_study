import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long result = 0;
    public static int[] A;
    public static int[] tmp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(A, 0, N - 1);
        System.out.println(result);

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int i = left;      
        int j = mid + 1; 
        int k = left;      

        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = A[j++];
                result += (mid - i + 1);
            }
        }
        while (i <= mid) tmp[k++] = A[i++];
        while (j <= right) tmp[k++] = A[j++];

        for (int l = left; l <= right; l++) {
            A[l] = tmp[l];
        }
    }
}