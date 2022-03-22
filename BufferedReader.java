import java.io.*;
public class BufferedReader {
    static void read(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] I1 = reader.readLine().split(" ");
        int[] arr1 = new int[I1.length];
        for (int i = 0; i < I1.length; i++){
            arr1[i] = Integer.parseInt(I1[i]);
        }
    }
}
