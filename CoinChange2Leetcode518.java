
public class CoinChange2Leetcode518 {
/* solution 1 Brute force */
    //time Complexity: O(2^N) exponential. for every possible amount that can be made out coins we will have that many sub problems and for each sub problems we can have 2 choices
    //Space Complexity: O(N), the depth of the recusrsive tree (every possible amount that can be made by combination and repeat so it will be large. May be depth * width of the tree
    //leetcode: yes, (won't work for large input)
    public int change(int amount, int[] coins) {

            if (coins == null) {
                return 0;
            }
            //we can never make amount 0 by any coins (coins will be atleast $1 minimum, returning 1 only for leetcode i guess for 0 amount they expect answer to be 1)
            if (amount == 0) {
                return 1;
            }

            return countCoinChange(amount, coins, 0);

        }

        public int countCoinChange(int amount, int[] coins, int index) {

            if (index >= coins.length) {
                return 0;
            }

            if (amount == 0) {
                return 1;
            }

            //choose the current and then try all coins ahain as we have infinite supply
            if (coins[index] <= amount) {
                return (countCoinChange(amount - coins[index], coins, index) + countCoinChange(amount, coins, index +1));
            }
            //do not choose the current coin
            return countCoinChange(amount, coins, index +1);
        }

   /* Solution 2 recusrion using memoization */
    //Time Complexity:O(amount *coins) ( be the depth of the recursion)
    //Space Complexity: O(amount * coins) for matrix
    //Leetcode: yes
        Integer dp[][];
        public int changedp(int amount, int[] coins) {

            if (coins == null) {
                System.out.println("coming in coins null case amount : "+ amount);
                return 0;
            }
            //just returning 1 here i think leetcode needed for a test case otherwise this should be 0. We can never make amout 0 by any coins.
            if (amount == 0) {
                System.out.println("amount : "+ amount);
                return 1;
            }
            dp = new Integer[coins.length][amount +1];
            //Arrays.fill(dp[0], -1);
            return countCoinChangedp(amount, coins, 0);

        }

        public int countCoinChangedp(int amount, int[] coins, int index) {

            if (index >= coins.length) {
                return 0;
            }

            if (amount == 0) {
                return 1;
            }
            if (dp[index][amount] != null) {
                return dp[index][amount];
            }
            //choose the current and then try all coins including the current coin as we have infinite supply
            if (coins[index] <= amount) {
                dp[index][amount] = countCoinChangedp(amount - coins[index], coins, index) + countCoinChangedp(amount, coins, index +1);
            } else {
                //do not choose the current coin and choose from remaining coins
                dp[index][amount] = countCoinChangedp(amount, coins, index +1);
            }
            return dp[index][amount];
        }
}
