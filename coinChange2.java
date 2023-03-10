/**
Time Complexity - O(M * N) where M is the size of coin array, N is the value of amount.
Space Complexity - O(N) where N is the value of amount.
 */
 
class Solution {
    public int change(int amount, int[] coins) {
        
        int[] ways = new int[amount + 1];
        ways[0] = 1;
        
        for(int coin : coins)
            for(int change = 1; change <= amount; change++)
                if(change >= coin) 
                    ways[change] += ways[change - coin];

        return ways[amount];
    }
}
