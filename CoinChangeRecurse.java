class Solution {
    public int change(int amount, int[] coins) {
       //recursion version
      //null case
      if(coins.length == 0 || coins == null) return 0;

      return helper(amount,coins,0);

    }
    private int helper(int amount, int coins[], int index) {
      //base case
      if(amount == 0) return 1;
      if(index == coins.length || amount < 0) return 0;
      //logic
      //choose
      int case1 = helper(amount-coins[index], coins, index);
      //dont choose
      int case2 = helper(amount,coins, index+1);

      return case1+case2;
    }
} 