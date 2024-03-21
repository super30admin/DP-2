using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
        }
        // Time Complexity: O(n)
        // Space Complexity: O(1) since manupulating the input
        public int MinCost(int[][] costs) {
            for(int i = 1; i<costs.Length; i++){
                costs[i][0] += Math.Min(costs[i-1][1], costs[i-1][2]);
                costs[i][1] += Math.Min(costs[i-1][0], costs[i-1][2]);
                costs[i][2] += Math.Min(costs[i-1][1], costs[i-1][0]);
            }
            return Math.Min(Math.Min(costs[costs.Length-1][0], costs[costs.Length-1][1]), costs[costs.Length-1][2]);        
        }

        // Time Complexity: O(m*n) where m is the number of coins and n is the amount
        // Space Complexity: O(n) for the dp array
        public int Change(int amount, int[] coins)
        {
            int[] dp = Enumerable.Repeat(0,amount+1).ToArray();
            dp[0] = 1;
            for(int i = 0; i<coins.Length; i++){
                for(int j = coins[i]; j<dp.Length; j++){
                    dp[j] += dp[j-coins[i]]; 
                }
            }
            return dp[amount];
        }
    }
}
