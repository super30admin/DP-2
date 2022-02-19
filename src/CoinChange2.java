//                              Top-down                            Bottom-Up
// Time Complexity:     O(amount/minimum_denomination)               O(m*n)
// Space Complexity:    O(2^(amount/minimum_denomination))            O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

package src;

import java.util.Arrays;

public class CoinChange2
{
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        Change2 cs = new Change2();
        System.out.println(cs.change(amount,coins));
    }
}

class Change2
{
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<amount+1; j++)
            {
                dp[i][j] = -1;
            }
        }
        return change(coins, 0, amount);

// ***************************** Bottom-Up Approach *****************************
//        long[] dp = new long[amount+1];
//        Arrays.fill(dp, 0);
//        dp[0] = 1;
//        for(int i=0; i<coins.length; i++)
//        {
//            int coin=coins[i];
//            for(int j=0; j<=amount; j++)
//            {
//                dp[j] = (j<coin) ? dp[j] : dp[j-coin]+dp[j] ;
//            }
//        }
//        return dp[amount]==0 ? 0 : (int)dp[amount];

    }
    private int change(int[] coins, int index, int amount)
    {
        if(amount == 0)                                                             // if amount is made out of this way
            return 1;
        if(amount < 0 || index == coins.length)                                     // if amount can't be made out of this way
            return 0;
        if(dp[index][amount] >= 0)
            return dp[index][amount];
        int noChoose = change(coins, index+1, amount);                        // not considering current coin
        int choose = change(coins, index, amount-coins[index]);             // considering current coin

        return  dp[index][amount] = noChoose+choose;                                // Getting number of ways to get amount
    }
}