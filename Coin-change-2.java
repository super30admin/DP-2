/*
 * TC: O(m*n), m: amount, n:no. of coins.
 * SC: O(m*n), m: amount, n:no. of coins. fro Memoization matrix.
 * 
 * Approach: Recurse until amount is reached, at each recursion we have two choice. either to choose
 * the coin or move to the next coin. Keep doing this until target is reach or all combination of coins
 * are done or the amount becomes 0. Also while calculating i will cache the result in order to 
 * use it later on.
 */

class Solution {
    public int change(int amount, int[] coins) {
        int[][] memo =  new int[amount+1][coins.length];

        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return helper(amount, coins, 0,memo);
    }

    private int helper(int amount, int[] coins, int idx, int[][] memo){
        //base
        if(amount == 0)
            return 1;
        
        if(amount < 0 || idx == coins.length)
            return 0;

        if(memo[amount][idx] != -1)
             return memo[amount][idx];
            
        int remainder = amount - coins[idx];
        int result = helper(remainder, coins, idx,memo) +  helper(amount, coins, idx+1,memo);
    

    memo[amount][idx]= result;
    return result;
    }
}