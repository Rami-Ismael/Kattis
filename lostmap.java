import java.io.*;
import java.math.*;
import java.util.*;

 
 
 
public class lostmap {
 
    static MyScanner in = new MyScanner();
    static   PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long H,W;
    static BitSet bs;
    static long mod = 1000000007;
      // All possible moves of a knight 
    static   int X[] = { 2, 1, -1, -2, -2, -1, 1, 2 }; 
    static int Y[] = { 1, 2, 2, 1, -1, -2, -2, -1 }; 
    static int [] dr   = {-1,0,0,1};
    static int [] dc = {0,1,-1,0};
    static int [] parent;
    static ArrayList<ArrayList<IP>> list = new ArrayList<>();
    static int max = 1000*1000*10;
   
    public static void main(String args[]) throws IOException {
    /**
1.What is the unknown:
2.What are the data: an array of tlen ght  the value is 10^9
3.What is the condition: 
4. understand the problem:
5. What are the cases edges in the problem:
6.What what max:
7. Are you using a data stcuture. And which one:
8.Is there reursion what is the base case. For example COINS:
*/
            int n  = in.nextInt();
            int [][] grid = new int[n][n];
            int [] [] p = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j] = in.nextInt();
                    p[i][j] = i;
                }   
            }
           for(int i=0;i<=max;i++){
                list.add(new ArrayList<>());
           }
           create(max);
           for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(grid[i][j]!=0)
                    list.get(grid[i][j]).add(new IP(i, j));
            }   
        }
        for(int i=0;i<=max;i++){
            for(int j=0;j<list.get(i).size();j++){
                int u = list.get(i).get(j).first;
                int v = list.get(i).get(j).second;
                if(findset(u)!=findset(v)){
                    out.println((u+1)+" "+(v+1));
                    union(u, v);
                }
            }
        }
          
            
            //print path
            out.flush();
    }
 static    void printPath(int i, int j,int [] [] p){
        if(i!=j) printPath(i, p[i][j],p);
            out.print(j);

    }
    static void create(int v){
        parent = new int[v+1];
        for(int i=0;i<=v;i++){
            parent[i] = i;
        }
    }
    static int findset(int v){
        if(v==parent[v]){
            return v;
        }
        return parent[v] = findset(parent[v]);
    }
    static void union(int a, int b){
        a = findset(a);
        b =findset(b);
        if(a!=b){
            parent[b] = a;
        }

    }
    
    private static int lowrBound(int[] a, int lo, int hi, int element) {
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(element>a[mid]){
                lo = mid+1;
            }else{
                hi  = mid;
            }
        }
        if(lo<a.length&&a[lo]==element){
            return lo+1;
        }
        return lo;
    }

    static long lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }
    static boolean isVowel(char c) {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='y'){
            return true;
        }
        return false ;
    }
    static class IP implements Comparable<IP>{
        public int first,second;
        IP(int first, int second){
            this.first = first;
            this.second = second;
        }
        public int compareTo(IP ip){
            if(first==ip.first)
                return second-ip.second;
            return first-ip.first;    
        }
        @Override
        public String toString() {
            return first+" -  "+second;
        }
 
    }
        
       static long gcd(long a, long b){
        return b!=0?gcd(b, a%b):a;
    }
 
        static boolean isEven(long a) {
            return (a&1)==0;
        }
    
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
