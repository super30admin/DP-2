// Time Complexity : O(M*2^N) for brute force and O(MN) for DP where N is number of coin denominations and M is amount
// Space Complexity : O(M+N) for brute force and O(MN) for DP
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// ============================== Brute - force TLE =============================================
/*
Algorithm:
=========
1. Pick or not pick every coin in the coin array and see if total amount is possible with that choice of coins
2. Sum pick and notPick up and that gives total ways an amount can be formed
*/

class Solution {
    public int change(int amount, int[] coins) {
        if( coins == null) return 0;
        return helper( amount, coins, 0);
    }
    
    // calculates every possible way multiple times - backtracking
    private int helper(int amount, int[] coins, int index) {
        
        if(amount == 0) return 1;
        if( amount < 0 || index >= coins.length ) return 0;
        
        // pick a coin
        int pick = helper(amount - coins[index], coins, index);

        // didn't pick a coin
        int notPick = helper( amount, coins, index+1); 
        
        //total ways would be combination of chosen and notChosen
        return pick + notPick;
        
    }
}



// ============================== Dynamic programming =======================================
/*
Algorithm:
=========
1. Calculate number of ways of getting the amount using dp matrix
2. Number of ways of getting 0 is 1 for all amounts. So, fill first row with 1's
3. Now, until column index is smaller than denomination, number of ways to get that amount is same as above
4. If index larger than denomination, total ways would be sum of above and value coins[i-1] behind the current value
*/


class Solution {
    public int change(int amount, int[] coins) {
        if( coins == null) return 0;
        
        //dp matrix to calculate total ways possible
        int[][] change = new int[coins.length+1][amount+1];
        
        for(int i = 0; i <= coins.length; i++) 
            change[i][0] = 1;
        
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                // sum of the value above and the value coins[i-1] steps behind
                change[i][j] = change[i-1][j] + (j < coins[i-1] ? 0: change[i][j - coins[i-1]]);
            }
        }
        return change[coins.length][amount];
    }
}
