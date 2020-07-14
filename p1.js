
// ## Problem1(https://leetcode.com/problems/paint-house/)

// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :

const minCost = (costs) => {
    if(!costs || costs.length === 0) return 0;
    const n = costs.length;
    
    for(let i = 1; i < n; i++) {
        for(let j = 0; j < 3; j++) {
            const idx1 = complement(j);
            const idx2 = complement(idx1);
            costs[i][j] = costs[i][j] + Math.min(costs[i -1][idx1], costs[i - 1][idx2]);
        }
    }
    
    return Math.min(
        costs[n - 1][0], 
        Math.min(costs[n - 1][1], costs[n - 1][2])
    );
};

const complement = (color) => {
    return color === 2 ? 0 : color + 1;
};