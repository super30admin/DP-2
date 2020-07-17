/*
Time Complexity: O(coins*amount)
Space Complexity: O(coins*amount)
Approach:
-Made a 2d array which is the dp array storing the value of number of ways coins  can be used to make the target
from 0 to target itself
-dp is about dividing into overlapping subproblems so here we are reaching to the target going with each coin
seeing whether we should take the coin or not and storing whichever number of  ways that coins can be used.

 */
public class CoinChangeII {
    public static int change(int amount, int[] coins){
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0;i <= coins.length;i++){
            dp[i][0] = 1;
        }
        for(int j = 1;j <= amount;j++){
            dp[0][j] = 0;
        }
        for(int i = 1;i<=coins.length;i++){
            for(int j = 1;j <= amount;j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];

    }
    public static void main(String args[]){
        System.out.println(change(5, new int[]{1,2,5}));
        System.out.println(change(11, new int[]{1,2,5}));
        System.out.println(change(11, new int[]{2,5}));

    }
}