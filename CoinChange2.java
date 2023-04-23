// Time Complexity : Exponential
// Space Complexity : O(n) In the worst case the maximum depth of recursion is n.
// Did this code successfully run on Leetcode : Time limit exceeded
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * Exahuastive search(recurssion) using DO NOT CHOOSE CHOOSE method.
 * Choose: Amount gets updated and index remains the same (Infinite supply)
 * Not choose: amount will be the same and increment the index.
 * Base case: If index is equal to length or we get negative amount. If amount is 0 we return 1.
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length < 1) {
            return 0;
        }
        return recurse(coins, amount,  0);
     }

     private int recurse(int[] coins, int amount, int index) {
        //Base case
        if(index == coins.length || amount < 0) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        //Logic: DO NOT CHOOSE CHOOSE METHOD
        int pick = recurse(coins, amount - coins[index], index);
        int notPick = recurse(coins, amount, index + 1);
        return pick + notPick;
     }
}

// Time Complexity : O(n*m); n = coins.length, m = amount;
// Space Complexity : O(n*m); n = coins.length, m = amount;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * DP where we consider dimension = length of the deciding factor. (amount is -ve, index == length). We creat dp[][] with coins + 1 = row and amount + 1 = coloumn
 * Fill 1st colum with 1. Fill dp matrix: if j < amount (As we added extra row we will get amount at 1 lesser index in array)
 * We copy from previous row,  else add previous row(0 notpick case) and 1(pick case) which is in same row 
 * but coloumn - amount + 1.
 */

class CoinChange2DP {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length < 1) {
            return 0;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0;  i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < coins.length + 1; i++) {
            for(int j = 1;  j < amount + 1; j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
