
public class Coin_Change_2 {
	public int change(int amount, int[] coins) {
		//Approach: Here we have to count the number of ways we can make up the target amount with the coins given
		//1. In initialization to make up zero with anything we have 1 way, and to make any target with zero we cannot make it, so its 0 ways.
		//2. next step, for every target if its less than new coin, we just get the number of ways of making that target from old coins. 
		//3. else, we we calculate target-new coin and add the no of ways of making up that remainder and add it with ways of making the target from old coins.
		//4. with this we build dp matrix and return the last element.
        int[][] dp = new int[coins.length+1][amount+1];
        if(amount == 0)
            return 1;
        for(int i=0;i<= coins.length;i++)
        {
            dp[i][0] = 1;
        }
        for(int i=0;i< amount+1;i++)
        {
            dp[0][i] = 0;
        }
        for(int i=1; i <= coins.length;i++)
        {
            for(int j=1;j< amount+1;j++)
            {
                if(j< coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
            }
        }

        return dp[coins.length][amount];
    }
}

//Time Complexity : O(nT) where n is the number of coins and T is the target amount 
//Space Complexity : O(nT) where n is the number of coins and T is the target amount 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :