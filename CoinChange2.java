// Time Complexity :O(c*n)
        // c = number of given coins,
        // n = all sub amount to reach target amount.
// Space Complexity :O(n+1), n = target amount
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
   //comming up with right dp approch

// Your code here along with comments explaining your approach
    /*
      create memoization array memo[0->amt+1].

      dp logic base case strting from lower amounts:
      given coin 1 only one way to make all sub amnts even 0(dont choose 1).
      given coin 1 and 2 , memo[amt -1] + memo[amnt -2] combinations.
      .
      .
      .
      soo on
      if amount can not be acheived by given coins, then result should be 0.
    */

    class Solution {
        public int change(int amount, int[] coins) {
            int memo[] = new int[amount+1];
            memo[0] = 1;
            for(int coin: coins){
                for(int i = 0; i< amount+1; i++){
                    if(coin > i)
                        continue;
                    memo[i]+= memo[i-coin];
                }
            }
            return memo[amount];
        }
    }
