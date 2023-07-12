# Time: O(3n) i.e O(n)
# Space: O(n),since in recursion stack and memo

# Top-down starting from 0th house
# at house j, if ith color is chosen then the min cost of coloring the j+1th house among other n-i colors plus cost[j][i] is its cost
# costs of coloring the house with each color as starting is computed and min among them is the min cost to color n-j houses

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        memo = [0 for _ in range(len(costs))]
        def dp(i):
            #base case
            if i==len(costs)-1:
                memo[i] = 1
                return
            
            if not memo[i+1]: dp(i+1)
            #case0
            costs[i][0] += min(costs[i+1][1], costs[i+1][2])
            #case1
            costs[i][1] += min(costs[i+1][0], costs[i+1][2])
            #case2
            costs[i][2] += min(costs[i+1][0], costs[i+1][1])
            
            memo[i] = 1
            return
        dp(0)
        return min(costs[0])