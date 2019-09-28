import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int size = 0;
    static String [] [] grid= new String[101][101];
    public static void main(String[] args) throws IOException {
	// write your code here
       BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine())!=null&&!s.equals("-1"))
        {
            size = Integer.parseInt(s);
            for (int i=0;i<size;i++)
                grid[i] = br.readLine().split(" ");
            ArrayList<Integer> weakVertics = new ArrayList<>();
            // we loop each vertex by row by row
            for (int row = 0;row<size;row++)
            {
                // the it look at it self
                ArrayList<Integer> niehgbors =new ArrayList<>();
                //check it neighbors
                for (int col =0;col<size;col++)
                    if (grid[row][col].equals("1"))
                        niehgbors.add(col);
                    // if it was less than one neighbor then we add the number to the string
                if (niehgbors.size()<=1)
                    weakVertics.add(row);
                else
                {
                    boolean notWeak = false;
                    //we check the nighbors of ht enieghborif ther have the in the list of the parent
                    for (int i=0;i<niehgbors.size()&&i<size;i++)
                    {
                        // go the the row of the vertex check if they have the smae nieghbor
                        for (int col =0;col<size;col++)
                            if (niehgbors.get(i)>0&&grid[niehgbors.get(i)][col].equals("1")&&col!=row&&niehgbors.contains(col))
                                notWeak = true;
                    }
                    if (!notWeak)
                        weakVertics.add(row);
                }

            }
            //create a string
            if (size!=0) {
                String answer = "";
                for (int i = 0; i < weakVertics.size(); i++)
                    answer += weakVertics.get(i) + " ";
                if (answer.length()>0)
                System.out.println(answer.substring(0, answer.length() - 1));
                else
                    System.out.println("");
            }
        }
    }
}