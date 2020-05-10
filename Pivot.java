import java.util.*;
import java.io.*;
public class Pivot {
    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) {
        MyScanner ms = new MyScanner();
        int N = ms.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<arr.length;i++)
        arr[i] = ms.nextInt();
        n = N;
        P = (int) (Math.log(n)/Math.log(2));
        dpmin = new long[P+1][n];
        dpmax = new long[P+1][n];
        for(int i=0;i<n;i++){
            dpmin[0][i] = arr[i];
            dpmax[0][i] = arr[i];
        }
        log2 = new int [n+1];
        for(int i=2;i<=n;i++){
            log2[i] = log2[i/2]+1;
        }
        //build sprse table combinoig the values of he repvious interval
        for(int p=1;p<=P;p++){
            for(int i=0;i+(1<<p)<=n;i++){
                long leftIntervalMin = dpmin[p-1][i];
                long rightInterval = dpmin[p - 1][i + (1 << (p - 1))];
                dpmin[p][i] = Math.min(leftIntervalMin, rightInterval);
                long leftIntervalMax = dpmax[p-1][i];
                long rightIntervalMax = dpmax[p - 1][i + (1 << (p - 1))];
                dpmax[p][i] = Math.max(leftIntervalMax, rightIntervalMax);
            }
        }
        int count =0;
        if(queryMin(1, arr.length-1)>arr[0])
        count++;
        for(int i=1;i<n-1;i++){
            int pivot = arr[i];
            //System.out.println(queryMax(0, i-1)+" "+pivot+" "+queryMin(i+1,arr.length-1));
            if(queryMax(0, i-1)<=pivot&&queryMin(i+1,arr.length-1)>pivot)
                count++;
        }
        if(queryMax(0, arr.length-1)<=arr[arr.length-1])
        count++;
            pw.println(count);
            pw.flush();
    }
 static   long queryMin(int l,int r){
        int length = r-l+1;
        int p = log2[length];
        int k = 1<<p;//2 to the power of p
        return Math.min(dpmin[p][l],dpmin[p][r-k+1] );
    }
 static    long queryMax(int l, int r){
        int length = r-l+1;
        int p = log2[length];
        int k = 1<<p;//2 to the power of p
        return Math.max(dpmax[p][l],dpmax[p][r-k+1] );
    }
    //the number of elmeents in the orginal input array
    static int n;
    //the maxiimum power of 2 needed. This values if floor
 static    int P;
    //fast long bas 2 larogitm lookup table
   static  int [] log2;
    //the sparse table values min
  static   long [][] dpmin;
    //the sparse table value max
  static   long [] []dpmax;
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
   
        public MyScanner() {
           br = new BufferedReader(new InputStreamReader(System.in));
        }
   
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
   
        int nextInt() {
            return Integer.parseInt(next());
        }
   
        long nextLong() {
            return Long.parseLong(next());
        }
   
        double nextDouble() {
            return Double.parseDouble(next());
        }
   
        String nextLine(){
            String str = "";
        try {
           str = br.readLine();
        } catch (IOException e) {
           e.printStackTrace();
        }
        return str;
        }
  
     }
}
