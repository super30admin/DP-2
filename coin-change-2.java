
// Solution -1

// TimeComplexity: O(n × amount)
// SpaceComplexity: O(amount)
//Explanation: I use a 1D array arr where arr[j] represents the number of ways to make amount j. 
// I initialize arr[0] = 1 because there is one way to make amount 0 (choose nothing). For each coin, I iterate through amounts and update
class Solution {
    public int change(int amount, int[] coins) {
        int[] arr = new int[amount+1];
        for (int j=0; j<amount+1; j++) {
            if(j==0){
                arr[j] =1;
            } else{
                arr[j] =0;
            } 
        }

        for(int i=0; i<coins.length; i++){
            for(int j=0; j<amount+1; j++){
                if(j>=coins[i]) {
                    arr[j] = arr[j] + arr[j-coins[i]];
                }

            }
        }
        return arr[amount];
    }
}


// Solution - 2

// TimeComplexity: O(n × amount)
// SpaceComplexity: O(n × amount)
// Explanation: Here dp[i][j] represents the number of ways to make amount j using the first i coins. For each coin, I either: Don’t choose it → dp[i-1][j]; Choose it → dp[i][j - coin]
// I add both cases to get total combinations.


class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=1; i<coins.length+1; i++) {
            for (int j=0; j<amount+1; j++){
                if(j==0) {
                    dp[i][j] =1;
                } else if(j<coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        } 
        return dp[coins.length][amount]; 
    }
}


// Solution - 3

// TimeComplexity: O(n × amount)
// SpaceComplexity: O(n × amount)
// Explanation: I use recursion where at each step I either: Skip the current coin (move to next index)
// Take the current coin (reduce amount but stay at same index). I store results in dp[idx][amount] to avoid recomputation. Each state is solved once

class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length+1][amount+1];
        return helper(amount, coins, 0, dp);     
    }

    private int helper(int amount, int[] coins, int idx, Integer[][] dp){
        
        // base
        if(amount<0|| idx>=coins.length) return 0;
        if(amount ==0) {
            return 1;
        }

        if(dp[idx][amount] !=null) {
            return dp[idx][amount];
        }


        // no choose
        int case1= helper(amount, coins, idx+1,dp);

        // choose
        int case2= helper(amount-coins[idx], coins, idx, dp);
        int sum = case1+case2;
        dp[idx][amount] = sum;

        return sum;
    }
}


// Solution - 4


// Time Complexity: O(2^n+m) where m is amount and n is length of coins array
// Space Complexity: O(m+n)
// Explanation: Here I recursively try both choices (take or skip coin) without memoization. 
// This causes repeated recomputation of the same states, leading to exponential time complexity.

class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);  
        
    }

    private int helper(int amount, int[] coins, int idx){
        // base
        if(amount<0|| idx>=coins.length) return 0;
        if(amount ==0) {
            return 1;
        }

        // no choose
        int case1= helper(amount, coins, idx+1);

        // choose
        int case2= helper(amount-coins[idx], coins, idx);

        return case1+case2;
    }
}
