/*TC : O(A*c) where N is the amount and c is the number of coins
SC : O(A*c) for the recursive stack call and the cache array
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */


//The apprroach taken is to construct a 2d matrix which stores the count for the previous amount.
//At any point, the number of combinations is equal to the combinations possible without using the coin + combinations for amount amount - coin
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length+1][amount+1];

      //  If the total amount of money is zero, there is only one combination: to take zero coins.
        cache[0][0] = 1;

        for (int i = 1; i <= coins.length; i++)
        {
            //zero combinations using no coins
            cache[i][0] = 1;
            for (int j = 1; j <= amount; j++)
            {
                if(j >= coins[i-1])
                    cache[i][j] = cache[i-1][j] + cache[i][j-coins[i-1]];
                else
                    cache[i][j] = cache[i-1][j];

            }
        }
        return cache[coins.length][amount];
    }
}
