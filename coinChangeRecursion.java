class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        
        if (coins == null || coins.length == 0) {
            return 0;
        }
        return helper(coins, amount, 0);
    }
    
    private int helper(int coins[], int amount, int index) {
        if (amount == 0) {
            return 1;
        }
        
        if (index >= coins.length || amount < 0) {
            return 0;
        }
        
        // Case 1: do not pick coin
        int case1 = helper(coins, amount, index + 1);
        // Case 2: pick coin
        int case2 = helper(coins, amount - coins[index], index);
        
        return case1 + case2;
    }
}