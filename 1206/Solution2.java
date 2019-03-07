import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i=1; i<11 ; i++) {
             
            int num = in.nextInt();
            int[] buildings = new int[num];
            int count = 0;
           
            for(int j=0; j<num ; j++) {
                buildings[j] = in.nextInt();
            }
 
            for(int j=2; j< num-2 ; j++) {
                int leftMax =getMax(buildings[j-2], buildings[j-1]);
                int rightMax = getMax(buildings[j+1], buildings[j+2]);
                int max = getMax(leftMax, rightMax);
                if(buildings[j] > max)
                    count += buildings[j] -max;
            }
                System.out.println("#"+i+" "+count);
            }
    }
     
    public static int getMax(int x, int y) {
        return x>=y ? x : y;
    }
}