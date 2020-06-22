public class RoomPainting {
 
    static MyScanner in = new MyScanner();
    static   PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static long H,W;
    static BitSet bs;
    static int mod = 1000000007;
    static int max = 10*100;
    static int BIT[]  = new int [max+1];
    public static void main(String args[]) throws IOException {
        int N = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>  arr = new ArrayList<Integer>(N);
        for(int i=0;i<N;i++){
            arr.add(in.nextInt());
        }
        long sum=0;
        Collections.sort(arr);
        for(int i=0;i<m;i++){
            int k =in.nextInt();
            //lower bound
            int lo =0;
            int hi = N-1;
            int mid =0;
            while(lo<hi){
                mid = (lo+hi)>>1;
                if(k>arr.get(mid)){
                    lo = mid+1;
                }else{
                    hi = mid;
                }
            }
            sum+=(arr.get(lo)-k);
        }
        out.println(sum);
        out.flush();
    }
