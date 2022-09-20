// Time Complexity :
// Recursion:
// Exponential
// DP:
// O(mn) Where m is the number of houses and n is the number of colors which is const - 3.
// So, O(m)
// Space Complexity :
// O(m) Where m is the number of houses
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Problem1(https://leetcode.com/problems/paint-house/)
// Your code here along with comments explaining your approach

var helper = (costs, index, color, amount) => {
    // Return total cost when no houses are left to be painted
    // Base case
    if(index >= costs.length)
        return amount;
    // Logic
    // If the house is painted red, the next house will be painted either blue or green. We return the minimum
    if(color === 0){ // Red
        return Math.min( helper(costs, index+1, 1, amount+costs[index][color]), helper(costs, index+1, 2, amount+costs[index][color]) )
    } else if(color === 1){ // Blue
        return Math.min( helper(costs, index+1, 0, amount+costs[index][color]), helper(costs, index+1, 2, amount+costs[index][color]) )
    } else { // Green
        return Math.min( helper(costs, index+1, 0, amount+costs[index][color]), helper(costs, index+1, 1, amount+costs[index][color]) )
    }
    
}
/**
 * @param {number[][]} costs
 * @return {number}
 */
var minCost = function(costs) {
    // If there are no houses, return 0
    if(costs === null || costs.length===0)
        return 0;
    // DP
    // n is the number of houses
    let n = costs.length;
    let dp = new Array(n);
    
    for(let i=0; i<dp.length; i++){
        // Each house can be painted using 3 options : Red Blue Green
        dp[i] = new Array(3);
    }
    // Set last house costs
    for(let j=0; j<3; j++){
        dp[n-1][j] = costs[n-1][j];
    }
    // For each house before, we set the cost as its cost + minimum of cost of the next house's possible colors
    for(i=n-2; i>=0; i--){
        dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i+1][0], dp[i+1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);
    }
    // The 1st row will have minimum costs for the cases when it has each color picked to paint
    return Math.min(dp[0][0], Math.min(dp[0][1], dp[0][2]));
    
    
    /* Recursive
    // We recurse for each of the 3 cases, when the 1st house is painted Red, Blue or Green
    // Red = 0; Blue = 1; Green = 2
    let costR = helper(costs, 0, 0, 0);
    let costB = helper(costs, 0, 1, 0);
    let costG = helper(costs, 0, 2, 0);
    
    return Math.min(costR, Math.min(costB, costG));
    */
};