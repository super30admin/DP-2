package S30_Codes.DP_2;

// Time Complexity : O(amount * coins.length)
//Space Complexity : O(amount)


class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] cache = new int[amount+1];
        cache[0] = 1;

        // cache[coin][amount] represents all possible ways to make given amount with using
        // coin denomination first coin to ith coin

        for(int coin : coins){
            for(int amt=coin; amt<=amount; amt++){
                // Not select case is already there in cache
                cache[amt] += cache[amt-coin];
            }
        }
        return cache[amount];
    }
}