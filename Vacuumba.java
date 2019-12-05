package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
//https://open.kattis.com/problems/vacuumba
//BluE Grand 
public class Main {
static int n;
static int m;
static double x;
static double y;
static StringTokenizer st;
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
         n  = Integer.parseInt(br.readLine());
        while (n-->0){
            //the stating orgin
            double degree =90;
            //the origin
            x = 0;
            y =0;
            //the amount of m lines
             m = Integer.parseInt(br.readLine());
            while (m-->0){
                st = new StringTokenizer(br.readLine());
                //degree step
                double degreeM =Double.parseDouble(st.nextToken());
                //the length od degree
                double length = Double.parseDouble(st.nextToken());
                // degree rotation
                 degree+=degreeM;
                //if the degree is negative
                if(degree<0)
                    degree+=360;
                //change of x
                double dx = Math.cos((degree/360)*2*Math.PI);
                //change in y
                double dy = Math.sin((degree/360)*2*Math.PI);
                //add the changes to the value
                x+=dx*length;
                y+=dy*length;
            }
            System.out.printf("%.6f %.6f ",x,y);
        }
    }
}
