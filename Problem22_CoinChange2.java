// Time Complexity : O(nd), n -> target amount, d -> number of coin denominations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;
        int[] combinations = new int[amount + 1];
        combinations[0] = 1;
        for(int coin : coins) {
            for(int amt = coin; amt < combinations.length; amt++) {
                combinations[amt] += combinations[amt - coin];
             }
        }
        return combinations[amount];
    }
}