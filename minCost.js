/**
 * Intuition: 
`helper(idx, color)` returns the **minimum cost to paint houses from index `idx` onward**, assuming the current house is painted with `color`.
For each house, we choose the **minimum cost among the two different colors** for the next house and add the current painting cost.
 Memoization stores results for each `(idx, color)` state so every subproblem is solved **only once**, giving linear time complexity.
 */
var minCost = function (costs) {
    let memo = Array.from(
        { length: costs.length },
        () => Array(3).fill(0)
    )

    const helper = (idx, color) => {
        // base
        if (idx === costs.length) {
            return 0;
        }
        let result = 0;
        // action
        if (memo[idx][color] !== 0) return memo[idx][color];
            if (color === 0) {
                result = Math.min(
                    helper(idx + 1, 1),
                    helper(idx + 1, 2)
                ) + costs[idx][0];
            } else if (color === 1) {
                result =  Math.min(
                    helper(idx + 1, 0),
                    helper(idx + 1, 2)
                ) + costs[idx][1];
            } else if (color === 2) {
                result =  Math.min(
                    helper(idx + 1, 0),
                    helper(idx + 1, 1)
                ) + costs[idx][2];
            }
            memo[idx][color] = result;
         return result;   
    }

    let color0 = helper(0, 0, 0);
    let color1 = helper(0, 1, 0);
    let color2 = helper(0, 2, 0);

    return Math.min(color0, color1, color2);
};