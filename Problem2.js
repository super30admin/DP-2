//Time: O(n), Space: O(n)
// Runs on leetcode - solution accepted
var minCost = function(costs) {
    let dp = [costs[0][0],costs[0][1],costs[0][2]];
     for(let i=1;i<costs.length;i++){
         let dp0 = costs[i][0] + Math.min(dp[1],dp[2]);
         let dp1 = costs[i][1] + Math.min(dp[0],dp[2]);
         let dp2 = costs[i][2] + Math.min(dp[0],dp[1]);
         dp = [dp0,dp1,dp2]
     }
      return Math.min(dp[0],dp[1],dp[2])
  };