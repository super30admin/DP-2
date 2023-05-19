public class CoinChangeTwo {
    public int change(int amount, int[] coins) {

        //null
        if(coins == null) return 0;

        int c = coins.length;
        int d = amount;

        //create dp array
        int[][] dp = new int[c+1][d+1];

        dp[0][0] = 1;

        // building dp array
        for(int i = 1; i <= c; i++){
            for(int j = 0; j <= d; j++){

                /*denomination of coin higher than current amount target
                is a no choose or zero case */
                if(coins[i-1] > j){
                    dp[i][j]= dp[i-1][j];
                }
                else{
                /* add both index selected and non selected ways
                choose or one case */
                    dp[i][j]= dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }
        // get dp result
        return dp[c][d];
    }
    public static void main(String[] args){
        CoinChangeTwo object = new CoinChangeTwo();
        int[] coinsGiven = {1,2,5};
        int amountTarget = 11;

        int result = object.change(amountTarget, coinsGiven);

        System.out.println("Number of combinations that make up the amount:  " + result);
    }
}
// 2D DP: Time = O(c*d) = O(coins array length * amount), Space = O(c*d) = O(coins array length * amount)
// 1D DP: Time = O(c*d) = O(coins array length * amount), Space = O(d) = O(amount)

// 1D Dp
/* class Solution {
    //Space optimized
    public int change(int amount, int[] coins) {

        //null
        if(coins == null) return 0;

        int c = coins.length;
        int d = amount;

        //create dp array
        int[] dp = new int[d+1];

        dp[0]= 1;

        // building 1D dp array
        for(int i = 1; i <= c; i++){
            for(int j = 0; j <= d; j++){

                /*denomination of coin higher than current amount target
                is a no choose or zero case
                if(coins[i-1] > j){
                     dp[j]= dp[j];
                }
                else{
                add both index selected and non selected ways
                choose or one case
                    dp[j]= dp[j] + dp[j - coins[i-1]];
                }

                if(j >= coins[i-1]){
                    dp[j]= dp[j] + dp[j - coins[i-1]];
                }
            }
        }
        // get dp result
        return dp[d];
    }
} */

//recursion base
/*
class Solution {
    public int change(int amount, int[] coins) {

        //null
        int cl = coins.length;
        if(cl == 0) return 0;

        // starting from last input in coins
        return helper(amount, coins, cl-1);
        /* starting from first input in coins
        return helper(amount, coins, 0);
    }

private int helper(int amount, int[] coins, int idx){

        //base
        if(amount == 0) return 1;

        //amount negative or index out of bounds
        if(amount < 0 || idx < 0) return 0;
        /* starting from first input in coins and reaching maximum length of coins matrix
        if(amount < 0 || idx == cl) return 0;

        logic
        //no Choose
        //int noChoose = helper(amount, coins, idx-1);
        /* starting from first input in coins, increase the index
        int noChoose = helper(amount, coins, idx+1);

        //choose
        int choose = helper(amount - coins[idx], coins, idx);

        // combine both cases
        return noChoose + choose;
        }
        }
 */
// Recursion: Space = O(1), Time = ?