import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (!findNum(target, arr)) {
                System.out.println(0);
            }else{
                System.out.println(1);
            }

        }

    }

    public static boolean findNum(int targetNum, int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int mid = 0;
        while (first <= last) {
            mid = (first + last) / 2;
            int midV = arr[mid];
            if (midV > targetNum) {
                last = mid - 1;
            } else if (midV < targetNum) {
                first = mid + 1;
            } else {
                return true;
            }

        }
        return false;
    }
}
