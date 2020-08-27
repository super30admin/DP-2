// Time Complexity : O(N x M) where N is the number of denominations and M is the amount
// Space Complexity : O(N x M) where N is the number of denominations and M is the amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Not really as it was similar to coins change 1.

public class CoinsChange2 {
    public int change(int amount, int[] coins) {
        int ways[][] = new int[coins.length + 1][amount + 1];
        
        //initialize row 0 with Integer.MAX_VALUE as we will need infinite 0s to collect 1,2,3,4...amount.
        for(int i = 1; i <= amount; i++) {
            ways[0][i] = Integer.MAX_VALUE;
        }
        
        //initialize column 0 with 1 as we will one 0 to collect 0.
        for(int i = 0; i <= coins.length ; i++){
            ways[i][0] = 1;
        }
        
        for(int i = 1; i <= coins.length ; i++) {
            for(int j = 1; j <= amount ; j++) {
                //number of ways if current coin denomination is not selected (only until i-1 selected).
                int lessOneWays = ways[i-1][j];

                //number of ways if we select current denomination.
                int minusCurrCoinWays;

                //if amount to make is less than current coin denomination, assign Integer.MAX_VALUE 
                //as there are infinite ways to create that amount with current coin selected
                //else number of ways by selecting current coin = ways(amount - current denomination)
                if(j - coins[i-1] < 0) {
                    minusCurrCoinWays = Integer.MAX_VALUE;
                } else {
                    minusCurrCoinWays = ways[i][j-coins[i-1]];
                }
                
                //if both are Integer.MAX_VALUE means its not possible
                if(lessOneWays == Integer.MAX_VALUE 
                   && minusCurrCoinWays == Integer.MAX_VALUE) {
                    ways[i][j] = Integer.MAX_VALUE;
                } 
                //if either one is INTEGER.MAX_VALUE, assign the other
                else if(lessOneWays == Integer.MAX_VALUE) {
                    ways[i][j] = minusCurrCoinWays;
                } else if(minusCurrCoinWays == Integer.MAX_VALUE) {
                    ways[i][j] = lessOneWays;
                } else {
                //else add both, this will give us all the possible ways
                    ways[i][j] = minusCurrCoinWays + lessOneWays;
                }
            }
        }
        
        //if the final value is Infinite means its not possible return 0
        //else return value
        return ways[coins.length][amount] == Integer.MAX_VALUE ? 0 : ways[coins.length][amount];
    }

}