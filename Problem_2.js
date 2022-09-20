// Time Complexity :
// Recursion:
// Exponential
// DP:
// O(mn) Where m is the total number of coins and n is the amount
// Space Complexity :
// O(mn) Where m is the total number of coins and n is the amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem2 (https://leetcode.com/problems/coin-change-2/)
// Your code here along with comments explaining your approach

var helper = (coins, amount, index) => {
    // Base Case
    if(amount===0)
        return 1;
    if(amount < 0 || index === coins.length)
        return 0;
    // Case 1 : Coin not selected
    let case1 = helper(coins, amount, index+1);
    // Case 2: Coin selected
    let case2 = helper(coins, amount - coins[index], index);
    return case1 + case2;
}
/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    if(coins === null || coins.length === 0)
        return 0;
    // Recursive method
    // return helper(coins, amount, 0);
    
    // DP
    // 2d dp of coins vs amount
    // The values indicate the total number of coin combination for the amount
    // The way to have 0 amount with 0 coins is 1 (Fill the 1st row and col accordingly)
    let dp = new Array(coins.length+1);
    for(let i=0; i<=coins.length; i++){
        dp[i] = new Array(amount+1);
        dp[i][0] = 1;
    }
    for(let j=1; j<dp[0].length; j++){
        dp[0][j] = 0;
    }
    for(let i=1; i<dp.length; i++){
        for(let j=1; j<dp[0].length; j++){
            if(j<coins[i-1]){
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
            }
        }
    }
    return dp[dp.length-1][dp[0].length-1];
};
