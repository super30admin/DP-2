// Time Complexity : O(M * N), Where M = amount and N = length of coins array.
// Space Complexity : O(M * N), Where M = amount and N = length of coins array + O(M) for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //Cache to memoize recursive calls
    private int[][] memo;
    public int change(int amount, int[] coins) {
        
        memo = new int[amount + 1][coins.length];

        // Fill up memo with all -1 saying all subproblems are yet to be solved
        for(int[] arr: memo)
        {
            Arrays.fill(arr, -1);
        }
        
        return helper(amount, coins, 0);
    }
    
    private int helper(int amt, int[] coins, int ind)
    {
        // We can always construct 0 amount using no coins. So There's one way
        if(amt == 0)
        {
            return 1;
        }

        // If We are out of coins we cant do it so no way
        if(ind >= coins.length)
        {
            return 0;
        }
        
        // If this problem was already solved and cached return from cache
        if(memo[amt][ind] != -1)
        {
            return memo[amt][ind];
        }
        
        // There can be two ways; init both to 0
        int ways1 = 0, ways2 = 0;
        
        // if currnt denom at given index in coins array is <= amt we can use that denom
        if(coins[ind] <= amt)
        {
            ways1 = helper(amt - coins[ind], coins, ind);
        }
        // We can always ignore this denom and move to next
        ways2 = helper(amt, coins, ind + 1);
        
        // Thus total ways will be sum of above two ways
        int ways = ways1 + ways2;
        
        // Store it in cache for future uses
        memo[amt][ind] = ways;
        
        return ways;
    }
}