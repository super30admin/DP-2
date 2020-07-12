/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
// DP SOLUTION
var change = function(amount, coins) {
    if (coins == null) return 0;
    let dp = new Array(amount + 1);
    dp.fill(0);
    dp[0] = 1;
    for (const coin of coins) {
        for (let i = coin; i < amount + 1; i++) {
            dp[i] += dp[i - coin]
        }
    }
    return dp[amount];
}

// RECURSIVE SOLUTION
// var change = function(amount, coins) {
//     return helper(amount, coins, 0, 0)
// };

// var helper = function(amount, coins, index, count) {
//     // Base Case
//     if (amount == 0) return count + 1;
//     if (amount < 0 || index >= coins.length) return 0;

//     // Logic
//     let case1 = helper(amount - coins[index], coins, index, count);
//     let case2 = helper(amount, coins, index + 1, count);
//     if (case1 == 0) return case2;
//     if (case2 == 0) return case1;
//     return case1 + case2;
// }
