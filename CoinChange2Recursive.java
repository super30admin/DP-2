/*
T.C O(2 pow m+n)
S.C O(m*n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/coin-change-ii/description/
// Any problem you faced while coding this : -
 */

//Use recursion to find exhaustive paths of all the cases that work. It gives time limit exceeded error for huge array
//as the time complexity is exponential
public class CoinChange2Recursive {
    public int change(int amount, int[] coins) {
        return helper(coins, 0, amount);
    }

    private int helper(int[] coins, int index, int remainingAmt ){
        //base
        if(remainingAmt<0 || index==coins.length) return 0;

        if(remainingAmt == 0) return 1;

        //dont choose
        int case0 = helper(coins, index+1, remainingAmt);
        //choose
        int case1 = helper(coins, index, remainingAmt - coins[index]);

        return case0+case1;
    }
}
