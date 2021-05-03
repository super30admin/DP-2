
// Time Complexity : O(n) n->len(costs)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


# Top-down

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in reversed(range(len(costs)-1)):
            # Starting with Coin1 path least cost
            costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2])
            # Starting with Coin2 path least cost
            costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2])
            # Starting with Coin3 path least cost
            costs[i][2] = costs[i][2] + min(costs[i+1][0],costs[i+1][1])
        return (min(costs[0][0],min(costs[0][1],costs[0][2])))


# Bottom-up

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(1,(len(costs))):
            # Starting with Coin1 path least cost
            costs[i][0] = costs[i][0] + min(costs[i-1][1],costs[i-1][2])
            # Starting with Coin2 path least cost
            costs[i][1] = costs[i][1] + min(costs[i-1][0],costs[i-1][2])
            # Starting with Coin3 path least cost
            costs[i][2] = costs[i][2] + min(costs[i-1][0],costs[i-1][1])
        return (min(costs[-1][0],min(costs[-1][1],costs[-1][2])))
