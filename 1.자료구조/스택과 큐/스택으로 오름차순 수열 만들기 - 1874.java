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

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int now = 1;

        StringBuffer bf = new StringBuffer();
        boolean result = true;

        for(int i=0; i<N; i++){
            if(arr[i] >= now){
                while(arr[i] >= now){
                    stack.push(now);
                    bf.append("+\n");
                    now++;
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                if(arr[i] < now){
                    int n = stack.pop();
                    if(n > arr[i]){
                        System.out.println("NO");
                        result = false;
                        break;
                    }else{
                        bf.append("-\n");
                    }
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}


