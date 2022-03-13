// Time Complexity : O(n) where n is length of costs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

var paintHouse = function(costs) {
    let cost = costs.length;
    for(let i=1; i < cost; i++) {
        //red
        costs[i][0] = costs[i][0] + Math.min(costs[i-1][1],costs[i-1][2]);
        //blue
        costs[i][1] = costs[i][1] + Math.min(costs[i-1][0],costs[i-1][2]);
        //green
        costs[i][2] = costs[i][2] + Math.min(costs[i-1][0],costs[i-1][1]);
    }
    let result = Math.min(costs[cost-1][0], Math.min(costs[cost-1][1], costs[cost-1][2]));
    return result;
};