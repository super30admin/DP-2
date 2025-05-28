// # DP-2

// ## Problem1(https://leetcode.com/problems/paint-house/)
// Did this code successfully run on Leetcode : couldnt try on leetcode as its a premium problem, but i ran it locally
// Any problem you faced while coding this : NONE

function minCost(costs) {

        //**Time Complexity : O(N) */
        //**Space Complexity : O(1) */
    if (costs === null || costs.length === 0) return 0;

    let n = costs.length;

    // Start with the last house's cost (base case)
    let red = costs[n - 1][0];
    let blue = costs[n - 1][1];
    let green = costs[n - 1][2];

    // Iterate from second last house to the first
    for (let i = n - 2; i >= 0; i--) {
        let tempRed = costs[i][0] + Math.min(blue, green);
        let tempBlue = costs[i][1] + Math.min(red, green);
        let tempGreen = costs[i][2] + Math.min(red, blue);

        red = tempRed;
        blue = tempBlue;
        green = tempGreen;
    }

    return Math.min(red, blue, green);
}


// Your code here along with comments explaining your approach 
// function minCost(costs) {
        //**Time Complexity : O(N) */
        //**Space Complexity : O(N) */
//     let n = costs.length
//     let dp = Array.from({ length: n }, () => new Array(3).fill(0));

//     dp[n-1][0] = costs[n-1][0]
//     dp[n-1][1] = costs[n-1][1]
//     dp[n-1][2] = costs[n-1][2]

//     for(let i =n-2;i>=0;i--){
//         dp[i][0] = costs[i][0] + Math.min(dp[i + 1][1], dp[i + 1][2]);
//         dp[i][1] = costs[i][1] + Math.min(dp[i + 1][0], dp[i + 1][2]);
//         dp[i][2] = costs[i][2] + Math.min(dp[i + 1][0], dp[i + 1][1]);

//     }
//     return Math.min(dp[0][0], dp[0][1], dp[0][2]);
// }


// function minCost(costs){
//     let colorR = helper(costs,0,0)
//     let colorB = helper(costs,0,1)
//     let colorG = helper(costs,0,2)
//     return Math.min(colorR,colorB,colorG)

//     function helper(cost,idx,color) {
        //**Time Complexity : O(2^n) */
        //**Space Complexity : O(N) */
//         if (idx === costs.length) {
//             return 0
//         }
//         if (color == 0) {
//             //red
//             let val = cost[idx][0] + Math.min(helper(cost,idx+1,1),helper(cost,idx+1,2))
//             return val
//         }
//         else if (color == 1) {
//             //blue
//             let val = cost[idx][1] + Math.min(helper(cost,idx+1,1),helper(cost,idx+1,2))
//             return val

//         }
//         else if (color == 2) {
//             //green
//             let val = cost[idx][2] + Math.min(helper(cost,idx+1,1),helper(cost,idx+1,2))
//             return val

//         }
//     }

// }

// console.log(minCost([[17,2,17],[16,16,5],[14,3,19]]))