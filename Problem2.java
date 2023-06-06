package DP2;
/**
 * 
 * Using bottom up DP approach
 * 
 * Time Complexity :
 * O(rows*cols) , where rows=length of coins array and cols=amount
 * 
 * Space Complexity :
 * O(rows*cols)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
	
    public int change(int amount, int[] coins) {
        if(coins.length ==0)
            return 0;

        int dp[][] = new int[coins.length+1][amount+1];

        dp[0][0]=1;
        
        for(int i=1;i<=coins.length;i++)
        {
            for(int j=0; j<=amount;j++){
                if(coins[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                
                else{
                    dp[i][j]=dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];


    }

}
