//
//  PaintHouses.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/5/26.
//

/*
 Approach - can't go with greedy approach because greedy gives local optimal solution. It's a high possibility that the solution that we are taking at row 1 can end up being the wrong choice.
 So explore all paths. - exhaustive approach
 we create tree for all elements present in row 1st
 depth - no of houses
 time complexity -> 2pow n(no of houses) * m(no of colors)
 */
class PaintHouses {
    init() {
        let minCost = minCost(costs: [[17, 2, 17], [16, 16, 5], [14, 3, 19]])
        print(" PaintHouses minCost \(minCost)")
        
        let minCostFromDpSolution = minCostUsingDP(costs: [[17, 2, 17], [16, 16, 5], [14, 3, 19]])
        print("min cost from dp solution \(minCostFromDpSolution)")
        
        let minCostFromUsingVars = minCostUsingThreeVariables(costs: [[17, 2, 17], [16, 16, 5], [14, 3, 19]])
        print("min cost by using 3 variables \(minCostFromUsingVars)")
        
        let minCostUsingDPMemoization = minCostUsingDPMemoization(costs: [[17, 2, 17], [16, 16, 5], [14, 3, 19]])
        print("min cost using dp memoization \(minCostUsingDPMemoization)")
    }
    
    func minCost(costs: [[Int]]) -> Int {
        
        let costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
                
        let colorRMinCost = helper(costs: costs, i: 0, j: 0)
        let colorBlueMinCost = helper(costs: costs, i: 0, j: 1)
        let colorGreenMinCost = helper(costs: costs, i: 0, j: 2)
        let minCost = min(colorRMinCost, colorBlueMinCost, colorGreenMinCost)
        return minCost
    }
    
    /*
     time compelxity - O(m * 2 pow n)
     */
    func helper(costs:[[Int]], i: Int, j: Int) -> Int {
        //base
        if (i == costs.count) {
            return 0
        }
        
        //logic
        var totalCost = 0
        if (j == 0) {
            //then consider elements for j = 1 and j = 2
            let cost1 = helper(costs: costs, i: i + 1, j: 1)
            let cost2 = helper(costs: costs, i: i + 1, j: 2)
            totalCost = min(cost1, cost2) + costs[i][j]
        } else if (j == 1) {
            //then consider elements for j = 0 and j = 2
            let cost1 = helper(costs: costs, i: i + 1, j: 0)
            let cost2 = helper(costs: costs, i: i + 1, j: 2)
            totalCost = min(cost1, cost2) + costs[i][j]
        } else if (j == 2) {
            //then consider elements for j = 0 and j = 1
            let cost1 = helper(costs: costs, i: i + 1, j: 0)
            let cost2 = helper(costs: costs, i: i + 1, j: 1)
            totalCost = min(cost1, cost2) + costs[i][j]
        }
        return totalCost
    }
    
    //Using dynamic Programming - tabulation
    /*
     Time complexity - O(n)
     Space complexity - O(n)
     */
    func minCostUsingDP(costs: [[Int]]) -> Int {
        var dp: [[Int]] = Array(repeating: Array(repeating: 0, count: costs[0].count), count: costs.count)
        //fill the bottom row
        dp[costs.count - 1][0] = costs[costs.count - 1][0]
        dp[costs.count - 1][1] = costs[costs.count - 1][1]
        dp[costs.count - 1][2] = costs[costs.count - 1][2]
         
        //loop from bottom
        for i in stride(from: costs.count - 2, through: 0, by: -1) {
            dp[i][0] = costs[i][0] + min(dp[i + 1][1], dp[i + 1][2])
            dp[i][1] = costs[i][1] + min(dp[i + 1][0], dp[i + 1][2])
            dp[i][2] = costs[i][2] + min(dp[i + 1][0], dp[i + 1][1])
        }
        return min(dp[0][0], min(dp[0][1], dp[0][2]))
    }
        
    
    //Can convert this matrix to a 1-D variable.
    //Since it's just 3 columns, we can use 3 variables as well.
    
    // time complexity - O(n), Space complexity - O(1)
    func minCostUsingThreeVariables(costs: [[Int]]) -> Int {
        var costRed = costs[costs.count - 1][0]
        var costBlue = costs[costs.count - 1][1]
        var costGreen = costs[costs.count - 1][2]
        
        for i in stride(from: costs.count - 2, through: 0, by: -1) {
            let tempRed = costRed
            let tempBlue = costBlue
            
            costRed = costs[i][0] + min(costBlue, costGreen)
            costBlue = costs[i][1] + min(tempRed, costGreen)
            costGreen = costs[i][2] + min(tempRed, tempBlue)
        }
        return min(costRed, min(costBlue, costGreen))
    }
    
    
    /*
     Path tracking ->
     approach 1 -as we go back, keep track of the elements which we selected in bottom rows. But for 10000 rows, lots of space will be wasted to keep track of path consisting of 10000 elements i each column.
     btter approach -> keep track of the previous element in previous row by using the column index. Storing only 1 int (next column index from where we are coming back) at each places.
     We can keep a path tracking matrix as well.
     */
}

extension PaintHouses {
    
    //using DP - Memoization
    func minCostUsingDPMemoization(costs: [[Int]]) -> Int {
        let costs = [[17, 2, 17], [16, 16, 5], [14, 3, 19]]
        
        var memo: [[Int]] = Array(repeating: Array(repeating: -1, count: 3), count: 3)
        
        let colorMinRed = helperForNMemoization(costs: costs, i: 0, j: 0, memo: &memo)
        let colorMinBlue = helperForNMemoization(costs: costs, i: 0, j: 1, memo: &memo)
        let colorMinGreen = helperForNMemoization(costs: costs, i: 0, j: 2, memo: &memo)
        
        return min(colorMinRed, min(colorMinBlue, colorMinGreen))
    }
    
    /*
     time compelxity - O(nm)
     */
    func helperForNMemoization(costs:[[Int]], i: Int, j: Int, memo: inout [[Int]]) -> Int {
        //base
        if (i == costs.count) {
            return 0
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j]
        }
        
        //logic
        var totalCost = 0
        if (j == 0) {
            //then consider elements for j = 1 and j = 2
            let cost1 = helper(costs: costs, i: i + 1, j: 1)
            let cost2 = helper(costs: costs, i: i + 1, j: 2)
            totalCost = min(cost1, cost2) + costs[i][j]
        } else if (j == 1) {
            //then consider elements for j = 0 and j = 2
            let cost1 = helper(costs: costs, i: i + 1, j: 0)
            let cost2 = helper(costs: costs, i: i + 1, j: 2)
            totalCost = min(cost1, cost2) + costs[i][j]
        } else if (j == 2) {
            //then consider elements for j = 0 and j = 1
            let cost1 = helper(costs: costs, i: i + 1, j: 0)
            let cost2 = helper(costs: costs, i: i + 1, j: 1)
            totalCost = min(cost1, cost2) + costs[i][j]
        }
        memo[i][j] = totalCost
        return totalCost
    }
}
