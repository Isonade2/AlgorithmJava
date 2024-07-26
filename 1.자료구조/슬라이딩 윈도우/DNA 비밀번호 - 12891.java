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
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] charArray = st.nextToken().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] minQuantityArr = new int[4];
        minQuantityArr[0] = Integer.parseInt(st.nextToken());
        minQuantityArr[1] = Integer.parseInt(st.nextToken());
        minQuantityArr[2] = Integer.parseInt(st.nextToken());
        minQuantityArr[3] = Integer.parseInt(st.nextToken());

        int first = 0;
        int last = M-1;
        int ans = 0;
        int[] arr = new int[4];

        for(int i = first; i<= last; i++){
            if(charArray[i] == 'A') arr[0]++;
            else if(charArray[i] == 'C') arr[1]++;
            else if(charArray[i] == 'G') arr[2]++;
            else if(charArray[i] == 'T') arr[3]++;
        }

        while(true){
            if(arr[0] >= minQuantityArr[0] && arr[1] >= minQuantityArr[1] &&
                    arr[2] >= minQuantityArr[2] && arr[3] >= minQuantityArr[3]) {
                ans++;
            }
            first++; last++;

            if(last >= N) break;

            if(charArray[first-1] == 'A') arr[0]--;
            else if(charArray[first-1] == 'C') arr[1]--;
            else if(charArray[first-1] == 'G') arr[2]--;
            else if(charArray[first-1] == 'T') arr[3]--;

            if(charArray[last] == 'A') arr[0]++;
            else if(charArray[last] == 'C') arr[1]++;
            else if(charArray[last] == 'G') arr[2]++;
            else if(charArray[last] == 'T') arr[3]++;

        }
        System.out.println(ans);
    }
}


