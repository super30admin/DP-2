// Time Complexity : O(n) 
// Space Complexity : O(n) number of rows
// Did this code successfully run on Leetcode : Yes

var minCost = function (costs) {
    if (costs === null || costs.length === 0) return 0;
    for (let i = costs.length - 2; i >= 0; i--) {
        costs[i][0] += Math.min(costs[i + 1][1], costs[i + 1][2]);
        costs[i][1] += Math.min(costs[i + 1][0], costs[i + 1][2]);
        costs[i][2] += Math.min(costs[i + 1][0], costs[i + 1][1]);
    }

    return Math.min(costs[0][0], costs[0][1], costs[0][2]);

};

//Without mutating the Array
var minCost = function (costs) {
    if (costs === null || costs.length === 0) return 0;
    var dp = new Array(costs.length);
    for (let i = 0; i < dp.length; i++) {
        dp[i] = new Array(3);
    }

    for (let j = 0; j < 3; j++) {
        dp[dp.length - 1][j] = costs[costs.length - 1][j];

    }

    for (let i = costs.length - 2; i >= 0; i--) {
        dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);
    }

    return Math.min(dp[0][0], dp[0][1], dp[0][2]);

};