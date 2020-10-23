// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



var minCost = function(costs) {
    //for color red, cost at i = min(costGreen[i-1], costBlue[i-1]+costs[0][i])
    //similarly for blue and green

    if(costs == null || costs.length == 0) return 0

    let n = costs.length;
    for(let i = 1; i < n; i++){
        let c =costs[i];
        let preC = costs[i-1]

        c[0] += Math.min(preC[1], preC[2])
        c[1] += Math.min(preC[0], preC[2])
        c[2] += Math.min(preC[1], preC[0])
    }
    return Math.min(costs[n-1][0],Math.min(costs[n-1][1], costs[n-1][2]))
};

