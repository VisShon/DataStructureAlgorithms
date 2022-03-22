import java.util.*;
import java.io.*;
public class Main{
public static void main(String[] args)throws IOException {
    // TODO Auto-generated method stub
    Reader.init(System.in);
    int n;
    String[] arr = Reader.init(System.out);
    System.out.println(arr[1]);



}
}


class Reader {
static BufferedReader reader;
static StringTokenizer tokenizer;

/** call this method to initialize reader for InputStream */
static void init(InputStream input) {
    reader = new BufferedReader(
                 new InputStreamReader(input) );
    tokenizer = new StringTokenizer("");
}

/** get next word */
static String next() throws IOException {
    while ( ! tokenizer.hasMoreTokens() ) {
        //TODO add check for eof if necessary
        tokenizer = new StringTokenizer(
               reader.readLine() );
    }
    return tokenizer.nextToken();
}
static String nextLine() throws IOException {
return reader.readLine();
}

static int nextInt() throws IOException {
    return Integer.parseInt( next() );
}

static double nextDouble() throws IOException {
    return Double.parseDouble( next() );
}
}
