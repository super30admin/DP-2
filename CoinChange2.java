// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach

/*
1. In the exaustive approch, we could have had two cases either we choose a coin or we don't choose a coin
2. case 1: when we choose a coin we reduce the coin's value from the target amount 
3. case 2: when we don't choose a coin we just move the index to the next coin
4. when the target amount reduces to 0 we return 1, since we have found 1 path way of using our coins to make the target amount
5. We return the total number of ways to make the sum amount by adding case 1 and case 2
6. In DP, we follow the same approch, we already know that number of ways of making sum 0 is 1 (by not choosing any coin, [1]^0 returns 1 in our recursion)
7. and we also know that number of ways of making any amount from 0 coin's of any value is 0
8. both the base conditions can help us in filling our dp matrix

*/

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins==null||coins.length==0)
            return 0;
        int[][] dp=new int[coins.length+1][amount+1];
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=0;
        for(int i=0;i<dp.length;i++)
            dp[i][0]=1;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[i].length;j++)
            {
                if(coins[i-1]>j)
                dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
        return dp[coins.length][amount];
    }
}
