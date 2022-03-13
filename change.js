// Time Complexity : O(S*n) where S is amount and n is coin denominator
// Space Complexity : O(S)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
    let dp = [new Array(amount+1).fill(0)];
    dp[0][0] = 1;
    for(let i=1; i<coins.length+1; i++) {
        for(let j=1; j<dp[0].length; j++) {
            if(!dp[i]) {
                dp[i] = new Array(dp[0].length);
                dp[i][0] = 1;
            }
            if(coins[i-1]>j) {
                dp[i][j] = dp[i - 1][j];
            } else {
                upIndex = dp[i-1][j];
                prevIndex = dp[i][j-coins[i-1]];
                dp[i][j] = (upIndex+prevIndex);
           }
        }
    }
    let result = dp[dp.length-1][dp[0].length-1];
    return result;
};