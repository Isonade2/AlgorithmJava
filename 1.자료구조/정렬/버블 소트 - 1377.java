import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        mData[] arr = new mData[N];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new mData(Integer.parseInt(st.nextToken()),i);
        }
        Arrays.sort(arr);

        int max = 0;
        for(int i = 0; i<N; i++){
            if(max < arr[i].index - i){
                max = arr[i].index-i;
            }
        }
        System.out.println(max+1);
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}


