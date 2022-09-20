// Brute force: 2^m*n (where m is the coins and n is the amount)
// Space complexity: 2^m*n

// Approach: brute force. recursion. Exhaustive approach

class Solution {
    int total = 0;
    public int change(int amount, int[] coins) {
        helper(amount, 0, coins, 0);
        return total;
    }
    
    private void helper(int target, int currentAmount, int[] coins, int idx) {
        // base
        if (currentAmount == target) {
            total++;
            return;
        }

        if (currentAmount > target || idx == coins.length) return;
        
        // logic
        // not choose
        helper(target, currentAmount, coins, idx+1);
        
        // choose
        currentAmount += coins[idx];
        helper(target, currentAmount, coins, idx);
    }
}