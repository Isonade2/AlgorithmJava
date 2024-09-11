import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while(K > 0){
            for(int i =0; i<N; i++){
                if(K < A[i]){
                    count += (K/A[i-1]);
                    K = K%A[i-1];
                    break;
                } else if (i == N-1) {
                    count += (K/A[i]);
                    K = K%A[i];
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
