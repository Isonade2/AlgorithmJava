import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());

        long first = 1;
        long last = 1;
        long sum = 1;
        long count = 1;
        while(last < N){
            if(sum < N){
                last++;
                sum += last;
            }
            else if(sum > N){
                sum -= first;
                first++;
            }
            else {
                count++;
                last++;
                sum += last;
            }
        }
        System.out.println(count);
    }
}
