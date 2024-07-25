import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int ans = 0;
        for(int i=0; i<N; i++){
            int first = 0;
            //음수도 포함되므로 I-1로 하면 놓친 범위가 생길 수도 있다.
            int last = N-1;

            while(true){
                //자기 자신을 포함하면 안되므로
                if(first == i){
                    first++;
                }
                if(last == i){
                    last--;
                }


                if(first >= last){
                    break;
                }

                if(arr[first]+arr[last] == arr[i]){
                    ans++;
                    break;
                } else if(arr[first]+arr[last] > arr[i]){
                    last--;
                } else if(arr[first]+arr[last] < arr[i]){
                    first++;
                }
            }
        }
        System.out.println(ans);
    }
}