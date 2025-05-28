// ## Problem2 (https://leetcode.com/problems/coin-change-2/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE

var change = function(amount, coins) {
    //Time Complexity : O(N*M)
    //Space Complexity : O(N*M)
    let dp = Array.from({ length: coins.length + 1 }, () => Array(amount + 1).fill(0));

    for (let i = 0; i <= coins.length; i++) {
        dp[i][0] = 1;
    }
    for (let i = 1; i <= coins.length; i++) {
        for (let j = 1; j <= amount; j++) {
            if (j >= coins[i - 1]) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[coins.length][amount];
};


// Your code here along with comments explaining your approach

// var change = function(amount, coins) {
        // Time Complexity : O(2^(n + m))
        // Space Complexity : O(N)
//     let re = helper(0,amount)
//     return re
//     function helper(idx,amount){
//         //baseCase
//         if(amount ==0) return 1
//         if(amount<0 || idx > coins.length-1) return 0
//         //Logic
//         //Choose
//         let pick = helper(idx,amount-coins[idx])
//         //NotChoose
//         let notPick = helper(idx+1,amount)

//         //return
//         return pick+notPick

//     }
// };