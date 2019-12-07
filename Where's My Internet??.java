import java.io.*;
        import java.util.StringTokenizer;

public class Main {
    //https://open.kattis.com/problems/wheresmyinternet
    //https://stackoverflow.com/questions/11823095/whats-the-fastest-way-to-output-a-string-to-system-out
    static  int N;
    static int M;
    static int [] union;
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        createUnion();
        int size = M;
        while (size-->0){
            st = new StringTokenizer(br.readLine());
            unite(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        //find all the house that not connected to to th interet
        connectedToInteret();

    }

    private static void connectedToInteret() throws IOException {
        int j=0;
        //  System.out.println(Arrays.toString(union));
        BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=2;i<=N;i++){
            if(find(i)!=1) {
                writer.write(i+"\n");
                j++;
            }
        }
        if(j==0)
            writer.write("Connected");
        writer.flush();
    }

    private static void createUnion() {
        //intilaize an array
        union = new int[N+1];
        //create a forr loop
        for (int i=1;i<=N;i++)
            union[i] = i;
    }
    static int find(int x){
        if(union[x]==x)
            return x;
        else{
            union[x] = find(union[x]);
            return union[x];
        }
    }
    static void unite(int x, int y){
        int u = find(x);
        int v = find(y);
        //if u is one
        if(u==1)
            union[v] = u;
        else
            union[u] = v;
    }

}
