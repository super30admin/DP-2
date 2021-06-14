//DP solution

class Solution {

    public int change(int amount, int[] coins) {

        // null case
        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[0].length; j++) {

                if (j < coins[i - 1]) {
                    // zero case : take from above

                    dp[i][j] = dp[i - 1][j];
                } else {

                    // one case: take from above and denomination steps back

                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }

            }

        }

        return dp[dp.length - 1][dp[0].length - 1];

    }

}

// //recursive solution

// class Solution {

// public int change(int amount, int[] coins) {

// //null case
// if(coins == null || coins.length ==0) return 0;

// return helper(amount,coins,0);
// }

// private int helper(int amount, int[] coins, int index){

// //base
// if(amount == 0) return 1;
// if(amount < 0 || index == coins.length) return 0;

// //logic

// //choose

// int case1 = helper(amount-coins[index],coins,index);

// // not choose

// int case2 = helper(amount,coins,index+1);

// return case1+case2;

// }

// }