// Time Complexity : O(n*m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No


var change = function(amount, coins) {
    if(coins == null) return 0
    let dp = []

    for(let i = 0; i <= coins.length; i++) {
        dp.push(new Array(amount+1).fill(0));
        dp[i][0] = 1
    }

    for(let i = 1; i <= coins.length; i++){
        for(let j = 1; j <= amount; j++){
            if(coins[i-1] > j){
                dp[i][j] = dp[i-1][j]
            } else {
                dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j]
            }
        }
    }
    return dp[dp.length-1][amount]
    
};