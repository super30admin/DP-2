# Here, N is number of houses.

'''Recursion Complexities'''


# Time Complexity : 2 ^ (N) 
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''Recursion with Memoisation'''

# Time Complexity : O(N * 3) Hence, O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        numHouses = len(costs)
        numColors = len(costs[0])
        def recur(house, color, memo):
            if house == numHouses:
                return 0
            if (house, color) in memo:
                return memo[(house, color)]
            
            
            minCost = float("inf")
            for c in range(numColors):
                if c == color:
                    continue
                currCost = recur(house + 1, c, memo) + costs[house][c]
                minCost = min(minCost, currCost)
            
            memo[(house, color)] = minCost
            return minCost
        
        
        return recur(0, -1, {})

'''Dynamic Programming'''

# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        dp = costs[0][:]
        
        for i in range(1, len(costs)):
            # there is no need to use this here. I just learnt about this in another problem. So tried it out.
            bestChoices = heapq.nsmallest(2, dp) #maintains two least costs in time 3log(2) i.e. O(1)
            for j in range(3):
                if dp[j] == bestChoices[0]: #if the previous cost is the least we have to use second best
                    dp[j] = bestChoices[1] + costs[i][j]
                else:
                    dp[j] = bestChoices[0] + costs[i][j]
        
        return min(dp)