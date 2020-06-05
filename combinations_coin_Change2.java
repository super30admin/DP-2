// 3 approaches: 1st recursive, 2nd is 2D table, 3rd is 1D table


/**
 * Recursive Approach: 2 way decision approach: consider the item and dont cinsider the item
 * Using this approach, find the number of ways amount can be made using the given coins of infinite number.
 */
// Time Complexity : Exponential O(2^n) where n is the number of coins
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes for small inputs, but for large inputs TLE
// Any problem you faced while coding this :  no


// Your code here along with comments explaining your approach
class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount,coins,0);
    }
    private int helper(int amount, int[] coins, int index){
        // System.out.println(amount);
        if(amount == 0)
            return 1;

        if(amount < 0 || index == coins.length)
            return 0;

        //take index
        int case1 = helper(amount-coins[index],coins,index);

        //dont take index
        int case2 = helper(amount,coins,index+1);

        return case1+case2;
    }
}

/**
 * Iterative Approach:
 * Rows of coins and amount as column, as it takes 1 way to get 0 amt using 0 coins
 *  Then, for first row - 0th coin, compute the ways of forming the amt == 0
 *  then, using the above row's values(no of ways the amt was formed using the coins at the previous and above) +
 *  number of ways the current coin can form the amount( previous columns value(ways formed by these coins for previous amount)) for which we wil append value of current coin
 *    Ex:  for amount 3 and coins 1,2
 *    c\a 0 1 2 3
 *    0   1 0 0 0     // 1 way to form amt 0 using coin 0 , but the rest amt cant be formed usig coin 0
 *    1   1 1 1 1     // first val, got it from top, since coin 1 is larger than the amt(cant use coin 1 to make amt 0), for coin 1 =>(top val(0) + (same row - 1(coin val to append)))
 *    2   1 1 2 2     // final ans is the last val in the matrix: 2
 */
// Time Complexity : O(m*n)  m: amount n: no of coins
// Space Complexity : O(m*n) m: amount n: no of coins
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  no

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];    // incl. 0 it will lead to 1 extra storage space
        dp[0][0] = 1;                                      // 1 way to form 0 amt using 0 coin
        for(int i=1;i<=amount;i++){
            dp[0][i] = 0;                                  // all the other values in here are 0 coz no amt can be achieved using coin 0
        }
        for(int i=1;i<=coins.length;i++)
            dp[i][0] = 1;                                 // all are 1 because all the rest of the coins are > 0 and takes from the above way i.e., from 0th coin

        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];      //if coin value is <= amt then using the above row's values(no of ways the amt was formed using the coins at the previous and above) + number of ways the current coin can form the amount( previous columns value(ways formed by these coins for previous amount)) for which we wil append value of current coin
                else
                    dp[i][j] = dp[i-1][j];                            // else just use the above row's values
            }
        }
        return dp[coins.length][amount];                             // return the final value stored in the cell of last coin used in the matrix and the gvn input amount
    }
}

/**
 * Iterative Approach:
 * Rows of coins and amount as column, as it takes 1 way to get 0 amt using 0 coins
 *  Then, for first row - 0th coin, compute the ways of forming the amt == 0
 *  then, using the above row's values(no of ways the amt was formed using the coins at the previous and above) +
 *  number of ways the current coin can form the amount( previous columns value(ways formed by these coins for previous amount)) for which we wil append value of current coin
 *    Ex:  for amount 3 and coins 1,2
 *    c\a 0 1 2 3
 *    0   1 0 0 0     // 1 way to form amt 0 using coin 0 , but the rest amt cant be formed usig coin 0
 *    1   1 1 1 1     // first val, got it from top, since coin 1 is larger than the amt(cant use coin 1 to make amt 0), for coin 1 =>(top val(0) + (same row - 1(coin val to append)))
 *    2   1 1 2 2     // final ans is the last val in the matrix: 2
 *
 *    SAME APPROACH: INSTEAD OF 2D USE 1D
 */
// Time Complexity : O(m*n)  m: amount n: no of coins
// Space Complexity : O(m) m: amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :  no

class Solution {
    public int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0]=1;

        for(int i=0;i<coins.length;i++)
        {
            for(int j=1;j<=amount;j++)
            {
                if(j>=coins[i])
                    dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}