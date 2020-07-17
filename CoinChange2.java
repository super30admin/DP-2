/*

## Problem2 (https://leetcode.com/problems/coin-change-2/)
You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:

5=5

5=2+2+1

5=2+1+1+1

5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
Note:

You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer


*/


/*
1) Brute force Solution

Time Complexity : k * 2^N  where K is no of choice for coins and N is amount
Space Complexity :  recursive space O(N)
is Worked on Leetcode :  NO 
                        Time Limit Exceded

Approach : we will build recursive algorithm for each of the coin where there are two choice availbel
for each coin either you will choose the coin or not 
and using this we will get the total no of ways to get the amount 
we will explore all the recursive sub problem and calculate it
*/
class Solution {
    // Brute Force Solution
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }
    
    public int helper(int amount, int [] coins, int index){
        
        if(amount== 0){
            return 1;
        }
        if(amount < 0  || index >= coins.length){
            return 0;
        }
//         if you choose the coin
        int case1  = helper(amount - coins[index], coins, index);
        
//         if you dont choose the coin
        int case2 = helper(amount, coins, index+1);
        
        return case1+case2;
    }

/*
    More Efficient Solution
    Time complexity :  O(M*N) M = no of coins N =  amount
    Space Complexity :  O(M*N)  M = no of coins N =  amount

    Worked on leetcode : YES

    we will maintain DP table for getting the count for the ways we can get perticular amount
    we will take the decision based on we will choose the coin or not
    if we will choose the coin then go back the coins denomination times in  same row  and add that t
    to the result we will get from the same column above row which stores the way we get amount
    without the that coin


*/
 public int change_DP_solution(int amount, int[] coins) {
        
        int [][] dp = new int [coins.length + 1 ] [ amount + 1 ];
//         first column for getting zero amount by not taking anything to 1 way
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1 ;
        }
        
//         first row zero
        for(int i = 1;i < dp[0].length; i++){
            dp[0][i] = 0;
        }
        
        for(int i=1;i< dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                if (j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i] [j] = dp[i-1] [j] /* if  we are not choosing perticular coin */
                        /* if we are choosing the coin go back coins times  in same */ 
                    + dp[i] [j - coins[i-1 ] ] ;
                }
                
            }
        }
        
        int n = coins.length ;
        int result = dp[n][amount];
        return result;
        
    }
   
}