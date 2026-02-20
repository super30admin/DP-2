/**
Intuition:
At each step, we decide whether to **use the current coin or skip it.
If we use it, we reduce the remaining amount, but stay at the same index (since coins are unlimited).
If we skip it, we move to the next coin — and memoization ensures we don’t recompute the same `(amount, index)` state twice.
 */
var change = function (amount, coins) {
    let coinsLength = coins.length;
    let memo = Array.from({ length: coinsLength }, () =>
        Array(amount + 1).fill(-1)
    );

    const helper = (amount, idx) => {
        // base
        if (amount === 0) return 1;
        if (idx === coinsLength || amount < 0) return 0;
        if (memo[idx][amount] !== -1) return memo[idx][amount];
        // action
        // 0 + 1
        let total = helper(amount, idx + 1) + helper(amount - coins[idx], idx);
        memo[idx][amount] = total;
        return total;

    }
    //call
    return helper(amount, 0);

};

// tabulation

var change = function(amount, coins) {
    const dp = Array(amount + 1).fill(0);
    dp[0] = 1; // base case: 1 way to make amount 0

    for (let coin of coins) {
        for (let j = coin; j <= amount; j++) {
            dp[j] += dp[j - coin];
        }
    }

    return dp[amount];
};