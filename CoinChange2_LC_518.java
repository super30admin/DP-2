
/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No just had difficulty understanding the time complexity of exhaustive solution and I came up with  O(2^[m+n] m - amount n - coints length)
but its O(2ⁿ * amount)
*/
public class CoinChange2_LC_518 {
//Exhaustive
/*
Time complexity -  O(2ⁿ * amount)
Space Complexity - O(m*n)
*/

    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }
    private int helper(int amount, int [] coins, int index) {
        //base case , we will have three base case
        /* 1. when the amount becomes 0, return 1 in this case becasue this is valid path and will be counted against output
           2. when the amount becomes negative , return 0 as this is not valid path
           3. when the coin array gets exhausted, return 0 as this is not valid path
        */
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;

        //logic
        int choose = helper(amount - coins[index],coins, index); //chossing the same index since I can choose same coin infinite times as stated in example
        int notChoose = helper(amount, coins, index+1); //since I am not choosing this indx of coin, I am considering next index, which is index +1

        return choose+notChoose;  //Since we need to return the no of ways to form amount, we consider choose + notchoose
    }
}
//Memoization - Top Down
/*
Time complexity - O(m*n)
Space Complexity - O(m*n)
*/
class SolutionMemoization {
    int memo[][];
    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        this.memo = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j = 0; j<=m; j++){
                memo[i][j] = -1;
            }
        }
        return helper(amount, coins, 0);
    }
    private int helper(int amount, int [] coins, int index) {
        //base case , we will have three base case
        /* 1. when the amount becomes 0, return 1 in this case becasue this is valid path and will be counted against output
           2. when the amount becomes negative , return 0 as this is not valid path
           3. when the coin array gets exhausted, return 0 as this is not valid path
        */
        if(amount == 0) return 1;
        if(amount < 0 || index == coins.length) return 0;

        if(memo[amount][index] != -1) return memo[amount][index]; //results are already computed , then return it

        //logic
        int choose = helper(amount - coins[index],coins, index); //chossing the same index since I can choose same coin infinite times as stated in example
        int notChoose = helper(amount, coins, index+1); //since I am not choosing this indx of coin, I am considering next index, which is index +1
        memo[amount][index] = choose + notChoose;
        return memo[amount][index];
    }

}

//Tabulation - Bottom up,We further can optimise to 1D array
/*
Time complexity - O(m*n)
Space Complexity - O(m*n)
*/
class SolutionBottomUp {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int [][] dp = new int[n +1][m+1];
        dp[0][0] =1; //when amount is 0 we by default return 1 even in brute force too

        for(int i = 1; i <= n; i++){ //coins starting  with 1 because we have already did dp[0][0] = 1 and rest will be 0
            for(int j = 0; j<=m; j++) { //amount stating with 0 because we still need to cover 0 amount for other coins since it will be filled out in below logic

                //when the amount < coin denomination always take prevoius rows result as it is since there is no coin denomination multiple of columns to look back for choose scenario
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]]; // I did not completely get coins[i-1] but its coin denomination
                }
                /*( prevoius row will be noChoose Scenario and prevoius columns will be Choose Scenario ( we have to go back to no of coins for example for coin 2 we will always take result from current column -2 column ) to fetch porevious calculated choose sceanrio for given coin) */
            }
        }
        return dp[n][m];
    }
}

/*
Tabulation- Space optimised
Time complexity - O(m*n)
Space Complexity - O(m) where m is amount

 */

class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int m = amount;
        int [] dp = new int[m+1];
        dp[0] =1; //when amount is 0 we by default return 1 even in brute force too

        for(int i = 1; i <= n; i++){ //coins starting  with 1 because we have already did dp[0][0] = 1 and rest will be 0
            for(int j = 0; j<=m; j++) { //amount stating with 0 because we still need to cover 0 amount for other coins since it will be filled out in below logic

                //when the amount < coin denomination always take prevoius rows result as it is since there is no coin denomination multiple of columns to look back for choose scenario
                if(j < coins[i-1]) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j-coins[i-1]]; // I did not completely get coins[i-1] but its coin denomination
                }
                /*( prevoius row will be noChoose Scenario and prevoius columns will be Choose Scenario ( we have to go back to no of coins for example for coin 2 we will always take result from current column -2 column ) to fetch porevious calculated choose sceanrio for given coin) */
            }
        }
        return dp[m];
    }
}
