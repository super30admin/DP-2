 class CoinChange2 {
     // Time Complexity : coins.length * amount
     // Space Complexity : coins.length * amount
     // Did this code successfully run on Leetcode : yes
     // Any problem you faced while coding this : no
     public int changeUsingDp(int amount, int[] coins) {

         //solution using dynamic programming tabulation / bottom up approach

         //creating a 2d array where columns  =  0-> amount and rows = count of coins + 1

         int [][] tabulation = new int[coins.length + 1][amount + 1];

         tabulation[0][0] = 1;

         for(int currentAmt = 1; currentAmt <= amount; currentAmt++) {
             tabulation[0][currentAmt] = 0;
         }

         for(int coinUsed = 1; coinUsed <= coins.length; coinUsed++) {

             for(int currentAmt = 0; currentAmt <= amount; currentAmt++) {
                 // case 1 when amount < coinUsed

                 if(coins[coinUsed - 1] > currentAmt) {
                     tabulation[coinUsed][currentAmt] = tabulation[coinUsed - 1][currentAmt];
                 }

                 //case 2 calculate sum of ways to reach current sum using the current available coins
                 else {
                     tabulation[coinUsed][currentAmt] = tabulation[coinUsed - 1][currentAmt] + tabulation[coinUsed][currentAmt - coins[coinUsed - 1]];
                 }
             }
         }
         return tabulation[coins.length][amount];
     }

     // Time Complexity : 2^(coins.length + amount)
     // Space Complexity : coins.length * amount
     // Did this code successfully run on Leetcode : yes , but gave time limit exceeded for input amount: 500 and coins: [3,5,7,8,9,10,11]
     // Any problem you faced while coding this : no
    public int changeUsingRecursion(int amount, int[] coins) {
        //solution using recursion against exhaustive approach

        return helper(amount, coins, 0, 0);
    }

    private int helper(int amount, int[] coins, int index, int numberOfWays){

        if(index >= coins.length) {
            return 0;
        }
        if(amount == 0) {
            return 1;
        }
        if(amount < 0) {
            return 0;
        }

        //logic
        //case 1 when we decide to choose the current coin denomination;
        int case1 = helper(amount - coins[index], coins, index, numberOfWays);

        // case 2 when we decide not to choose the current coin denomination
        int case2 = helper(amount , coins, index + 1, numberOfWays);

        return case1 + case2;
    }
}
