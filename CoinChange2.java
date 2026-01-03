// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :

// We divide the problem to find out  which combination of coins([C1], [C1, C2], .... [C1, CN]) can add up to given amount.
// So, we can choose a coin, how many ever times it is needed to make an amount, but once it is selected we will not
// select that coin again and will move to find the combination with the next coin. So the number of ways will,
// C = Combinations(starting with C1) + Combinations(starting with C2)..... Combinations(starting with CN)
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange2 {

    public int change() {
        int amount = 5;
        int[] coins = {1,2,5};

    //    int numberOfWays = changeRecursive(amount, coins, 0);
    //    int numberOfWays = changeMemo(amount, coins, 0, new HashMap<>());
    //    int numberOfWays = changeTabulation(amount, coins);
        return changeTabulation1D(amount, coins);
    }

    public int changeTabulation1D(int amount, int[] coins){
        // N: number of values in coins, A: amount
        // Time Complexity : O(NA), Will need to go through all amount values for each coin;
        // Space Complexity : O(A)
        int rows = coins.length+1;
        int cols = amount+1;
        int[] table = new int[cols];

        for (int i = 1; i < rows; i++) {
            int currentCoin = coins[i-1];
            // indicates to make sum 0 using any coin[i], there is at least 1 way, that is by skipping the coin
            table[0] = 1;
            for (int j = 1; j < cols; j++) {
                if(currentCoin <= j){
            //Save the number to make the amount j using current coin and using the previous coin(value already saved at
            // at current cell)
                  table[j] = table[j-currentCoin] + table[j];
                }
            }
        }

        return table[cols-1];
    }


    private int changeTabulation(int amount, int[] coins){
        // N: number of values in coins, A: amount
        // Time Complexity : O(NA), Will need to go through matrix of size NxA;
        // Space Complexity : O(NA)
        int rows = coins.length+1;
        int cols = amount+1;

        int[][] table = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            // indicates to make sum 0 using any coin[i], there is at least 1 way, that is by skipping the coin
            table[i][0] = 1;
        }

        // Go through each row, calculating number of ways to create amount j using coin[i]
        for(int i = 1; i < rows; i++){
            int currentCoin = coins[i-1];
            for(int j = 1; j < cols; j++){
                int include = 0;
                if(currentCoin <= j){
                    // Give me number of ways to count  the rest of value (amount-coin[i]) using current coin itself
                    include = table[i][j-currentCoin];
                }
                // dont include the current coin, get number of ways from previous coins to create j amount
                int exclude = table[i-1][j];
                table[i][j] = include + exclude;
            }
        }
        return table[rows-1][cols-1];
    }

    private int changeMemo(int amount, int[] coins, int index, HashMap<List<Integer>, Integer> memo) {
        // N: number of values in coins, A: amount
        // Time Complexity : O(2(N+A)) = ~ O(N+A), fetches already calculated subproblem from memo
        // Space Complexity : O(N+A), max depth of recursion calls, so N+A calls on the stack frame.
        // Also, similar amount of values in the memo hashmap

        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(index >= coins.length) return 0;
        
        List<Integer> key = List.of(amount, index);
        if(memo.containsKey(key)) return memo.get(key);
        
        int include = changeMemo(amount-coins[index],coins, index, memo);
        int exclude = changeMemo(amount, coins, index+1, memo);
        int numberOfWays = include + exclude;
        memo.put(key, numberOfWays);
        return numberOfWays;
    }

    private int changeRecursive(int amount, int[] coins, int index) {
        // N: number of values in coins, A: amount
        // Time Complexity : O(2^(N+ A)), at every subproblem call, we make decision, whether to take that coin or skip that coin
        // for example, we can take the coin A from 0 to multiple times, till it reaches the amount. So N coins each can be taken till "amount" times
        // Space Complexity : O(N+A)
        // Since we are not going to use the same coin again, only first case will occur, 2nd and 3rd combination would not.
        // 5 : 1+1+1+2...
        // 5 : 1+2+1+1
        // 5 : 2+1+1+1
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (index >= coins.length) return 0;

        // take this coin till it makes the amount and never take it again later.
        int include = changeRecursive(amount - coins[index], coins, index);

        // skip the coin
        int exclude = changeRecursive(amount, coins, index+1);
        return include + exclude;
    }

    // Added for personal notes
    public int changeRecursiveIncorrect(int amount, int[] coins){
        // If we use an approach that we used in Coin change 1, it would cause duplicates like, so incorrect number of ways
        // 5 = 1+1+1+2
        // 5 = 2+1+1+1
        if(amount < 0) return 0;
        if(amount == 0) return 1;

        int numberOfWays = 0;
        for(int coin: coins){
            if(coin <= amount){
                numberOfWays += changeRecursiveIncorrect(amount-coin, coins);
            }
        }

        return numberOfWays;
    }


}
