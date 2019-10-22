

// time complexity is O(n) (although its a matrix but still columns are constant ie 3 ) and space complexity is o(n);
// my coding is giving some error which i cant understand
// in this we are making a dp matrix and finding their values according to the algorithm and return the min of the last row in th matrix
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
        int [][] dp= new int [cost.length][cost[0].length];
       
        dp[0][0]=cost[0][0];
         dp[0][1]=cost[0][1];
          dp[0][2]=cost[0][2];
          for(int i=1;i<cost.length;i++)
          {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+cost[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+cost[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+cost[i][2];
            
          }
          int n=dp.length;
          return Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
    }
}