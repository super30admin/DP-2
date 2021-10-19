// Time Complexity : O(n*amount)
// Space Complexity : O(n*amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class CoinChange_2 {
  public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];
        
        //Initialize the row
        for(int i=0;i<=amount;i++){
            dp[0][i]=0;
        }
        
        //Initialize the column
        for(int i=0;i<=coins.length;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                 dp[i][j]=dp[i-1][j];
               if(j>=coins[i-1]){
                 dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
        
    }
}
