

// time complexity is O(n) (although its a matrix but still columns are constant i.e 3 ) and space complexity is o(1);
// my coding is giving some error which i cant understand
// in this we are making 3 variables and updating their values and then finding out the min of the calculated values
import java.util.*;
public class Main {
    public static void main(String args[]) {
         Scanner input =new Scanner(System.in);
        int m=input.nextInt();
         Scanner input1 =new Scanner(System.in);
        int n=input1.nextInt();
        int [][] dp= new int [m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               Scanner input3 =new Scanner(System.in);
                input3.nextInt();

            }
        }
        return mincost(dp);
    }

     public int mincost(int [][] cost)
    {
       int red=cost[0][0];
       int blue=cost[0][1];
       int green=cost[0][2];
       for(int i=1;i<m;i++)
       {

             int newred= Math.min(blue,green)+ cost[i][0];
             int newblue= Math.min(red,green)+ cost[i][1];
             int newgreen= Math.min(blue,red)+ cost[i][2];
             red=newred;
             blue=newblue;
             green=newgreen;
       }
       return Math.min(red,Math.min(green,blue));

          }
}
