/**
 * // Number of ways we can achieve the amount using coins
 * 
 * // Time Complexity : (coin.length+1 * amount+1) // Space Complexity :
 * (coin.length+1 * amount+1) // Did this code successfully run on Leetcode :Yes
 * // Any problem you faced while coding this : No // Your code here along with
 * comments explaining your approach
 */
public class CoinWaysRec {

    public int change(int amount, int[] coins) {

        return countWays(coins, amount, 0);
    }

    public int countWays(int[] coins, int amount, int index) {

        if (amount == 0) {
            return 1;
        }

        if (index > coins.length || amount < 0)
            return 0;

        int caseNo = countWays(coins, amount, index + 1);
        int caseYes = countWays(coins, amount - coins[index], index);
        return caseNo + caseYes;
    }

    public static void main(String[] args) {

    }
}