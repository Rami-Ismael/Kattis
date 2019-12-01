https://open.kattis.com/problems/haypoints
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int words = Integer.parseInt(st.nextToken());
        int paragraph = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> word = new HashMap<>();
        for(int i=0;i<words;i++){
            st  = new StringTokenizer(br.readLine());
            word.put(st.nextToken(),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<paragraph;i++){
            int sum=0;
            String lines ;
            while((lines=br.readLine())!=null&&!lines.equals(".")){
                st = new StringTokenizer(lines);
                while (st.hasMoreTokens()){
                    String n = st.nextToken();
                    if(word.containsKey(n))
                        sum+=word.get(n);
                }
            }
            System.out.println(sum);
        }
    }
}
