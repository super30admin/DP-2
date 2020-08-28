//// Time Complexity : O(n) where n is length of costs array
//// Space Complexity : O(3*N) or (N) where N is length of costs array
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :
// pretty straightforward

//// Your code here along with comments explaining your approach
// At each level and for each column, calculate the min cost by considering your possible choices and costs from the previous level
// Find the minimum cost at the last level and return that
var minCost;

minCost = function(costs) {
  var i, j, ref;
  if (costs.length === 0) {
    return 0;
  }
  for (i = j = 1, ref = costs.length; (1 <= ref ? j < ref : j > ref); i = 1 <= ref ? ++j : --j) {
    costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
    costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
    costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
  }
  return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
};

//# sourceMappingURL=problem2.js.map
