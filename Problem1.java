import java.util.*;
public class problem1 {
    // using brute force
    public static void findLowestCost(int[][] val) {
               for(int i=1; i<val.length; i++){
        val[i][0] += Math.min(val[i-1][1], val[i-1][2]);
        val[i][1] += Math.min(val[i-1][0], val[i-1][2]);
        val[i][2] += Math.min(val[i-1][0], val[i-1][1]);
    }
 
    int m = val.length-1;
    System.out.println("The lowest cost to paint is "+Math.min(Math.min(val[m][0], val[m][1]), val[m][2]));

    }
    
    
    



    public static void main(String[] args) {
        int[][] val = new int[][] { {3,6,4}, {1,7,6}, {4,7,1}, {9,9,1}, {2,2,1} };
        findLowestCost(val);
    }
}
