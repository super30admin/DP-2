// Time Complexity : O(n * C) c being number of coins and n being the amount
// Space Complexity : O(n) n being the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create the prev array with size amount + 1 since there would be base condition for 0 amount
// Assign prev[0] to 1 as there would be 1 combination
// Loop through the rows/coins and columns/amount.
// we will fill the prev array depending on if we are secting the current coin or not.
// Ultimately we progress through it and our answer would be reach at the amount of cur/prev.
class Solution {
    public int change(int amount, int[] coins) {
        int prev[] = new int[amount + 1];
        prev[0] = 1;
        for(int i = 0; i < coins.length; i++){
            int[] cur = new int[amount + 1];
            cur[0] = 1;
            
            for(int j = 1; j <= amount; j++){
                
                int noSelect = prev[j];
                int select = (j - coins[i] < 0) ? 0: cur[j - coins[i]];
                cur[j] = noSelect + select;
            }
            prev = cur;
        }
        return prev[amount];
    }
}