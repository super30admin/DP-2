// 518. Coin Change II
// https://leetcode.com/problems/coin-change-ii/description/

// Solution 1 => Recursion (TLE)

/**
 * Time Complexity: O(2 ^ (n + m)), where n = no. of coins and m  is amount. Since at every level we give 2 calls and we have levels till either n is exhausted or amount is exhausted
 * Space Complexity: O(n + m), levels in a tree
 */

class Solution {
    public int change(int amount, int[] coins) {
        return helper(coins, 0, amount);
    }

    private int helper(int coins[], int idx, int amt){
        //base condition
        if(amt == 0){
            return 1;
        }

        if(idx >= coins.length || amt < 0){
            return 0;
        }

        // logic
        if(coins[idx] > amt){ // if coin denom is greater than amount
            return helper(coins, idx + 1, amt);
        }

        // 2 choices

        int case1 = helper(coins, idx + 1, amt); // not pick
        int case2 = helper(coins, idx, amt - coins[idx]); // pick

        return case1 + case2; 
    }
}


// Solution 2 => Memoization/Top - Down

/**
 * Time Complexity: O(m * n) where n = no. of coins & m = amount. 
 * Space Complexity: O(m * n) where we store all combinations of coins and amount (coins * amount)
 */

class Solution {

    int memo[][];

    public int change(int amount, int[] coins) {
        
        this.memo = new int[coins.length][amount];

        for(int i = 0 ; i < coins.length ; i++){
            for(int j = 0 ; j < amount ; j++){
                memo[i][j] = -1;
            }
        }

        return helper(coins, 0, amount);
    }

    private int helper(int coins[], int idx, int amt){
        //base condition
        if(amt == 0){
            return 1;
        }

        if(idx >= coins.length || amt < 0){
            return 0;
        }

        if(memo[idx][amt - 1] != -1){
            return memo[idx][amt - 1];
        }

        // logic
        if(coins[idx] > amt){ // if coin denom is greater than amount
            return helper(coins, idx + 1, amt);
        }

        // 2 choices

        int case1 = helper(coins, idx + 1, amt); // not pick
        int case2 = helper(coins, idx, amt - coins[idx]); // pick

        return memo[idx][amt - 1] = case1 + case2; 
    }
}

// Solution 3 => Tabulation / Bottom-Up


/**
 * Time Complexity: O(m * n) where n = no. of coins & m = amount. 
 * Space Complexity: O(m) where m is amount
 */


class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length + 1;
        int m = amount + 1;

        int [] dp = new int[m];

        dp[0] = 1; // amount 0 can be achieved by 1 way, hence initialize with 1

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                if(coins[i-1] <= j){ // if coin denom is less than or equal to amount
                    dp[j] = dp[j] + dp[j - coins[i - 1]]; // add => not pick coin +  pick coin
                }
            }
        }

        return dp[m - 1];
    }
}