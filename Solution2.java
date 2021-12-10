// Time Complexity :O(mn) m=length of coins array ,n=amount
// Space Complexity :O(mn) m=length of coins array ,n=amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution2 {
    public int change(int amount, int[] coins) {
        if(coins==null || coins.length==0)
           return -1;
       
       int [][] dp=new int[coins.length+1][amount+1];
       
       // to get amount=0, there is only 1 way with any denomination
       for(int i=0;i<coins.length+1;i++){
           dp[i][0]=1;
       }
       
       for(int i=1;i<coins.length+1;i++){
       for(int j=1;j<amount+1;j++){
           //if amount is less than denomination
           if(j<coins[i-1])
               dp[i][j]=dp[i-1][j];
           else
               dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
   }
       }
       
       return dp[coins.length][amount];
   
}
}
