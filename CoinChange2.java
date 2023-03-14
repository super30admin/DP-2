/**
    Time Complexity - O(N * M) where N is the number of coins * amount.
    Space Complexity - O(M) where M is the amount.
 */
class CoinChange2 {
    public int change(int amount, int[] coins) {
        
        int[] ways = new int[amount + 1];
        ways[0] = 1;

        /**
        for loop order is important. If swapped, duplicates would occur.
         */
        for(int coin : coins)
            for(int change = 1; change <= amount; change++)
                if(change >= coin) 
                    ways[change] += ways[change - coin];

        return ways[amount];

    }
}
