// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} costs
 * @return {number}
 */
var minCost = function(costs) {
  if (costs.length === 0 || costs === null) {
    return 0;
  }

  var n = costs.length;

  for (var i = n - 2; i >= 0; i--) {
    costs[i][0] = costs[i][0] + Math.min(costs[i + 1][1], costs[i + 1][2]);
    costs[i][1] = costs[i][1] + Math.min(costs[i + 1][0], costs[i + 1][2]);
    costs[i][2] = costs[i][2] + Math.min(costs[i + 1][0], costs[i + 1][1]);
  }

  var min = Number.MAX_VALUE;

  for (var i = 0; i < 3; i++) {
    min = Math.min(min, costs[0][i]);
  }
  return min;
};
