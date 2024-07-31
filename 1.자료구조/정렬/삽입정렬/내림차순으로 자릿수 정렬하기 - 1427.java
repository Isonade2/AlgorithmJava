import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int[] arr = new int[s.length()];
        for(int i =0; i<s.length(); i++){
            arr[i] = s.charAt(i)-'0';
        }

        for(int i =0; i<arr.length; i++){
            int max = arr[i];
            boolean swap = false;
            int index = 0;
            for(int j = i + 1; j<arr.length; j++){
                if(max < arr[j]){
                    max = arr[j];
                    swap = true;
                    index = j;
                }
            }
            if(swap == true) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        for (int i : arr) {
            System.out.print(i);
        }

    }
}




