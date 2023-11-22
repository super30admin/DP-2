/*
T.C O(2 pow m+n)
S.C O(m*n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/coin-change-ii/description/
// Any problem you faced while coding this : -
 */

//Use recursion to find exhaustive paths of all the cases that work. It gives time limit exceeded error for huge array
//as the time complexity is exponential
public class CoinChange2RecursiveVoid {
    public static int ways;
    public int change(int amount, int[] coins) {
        ways = 0;
        helper(coins, 0, amount);
        return ways;
    }

    private void helper(int[] coins, int index, int remainingAmt ){
        //base
        if(remainingAmt<0 || index==coins.length)
        {   return;
        }

        if(remainingAmt == 0) {
            ways++;
            return;
        }

        //dont choose
        helper(coins, index+1, remainingAmt);
        //choose
        helper(coins, index, remainingAmt - coins[index]);
    }
}
