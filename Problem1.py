# https://leetcode.com/problems/paint-house/description/

# Exhaustive approach
class Solution:
    minimum = float('inf')
    def minCost(self, costs):
        self.helper(costs, 0, 0, 0) #starting from 0th house and choosing red
        self.helper(costs, 0, 1, 0) #starting from 0th house and choosing blue
        self.helper(costs, 0, 2, 0) #starting from 0th house and choosing green
        return self.minimum
        
    def helper(self, costs, i, color, totalCost):
        
        if i == len(costs):
            self.minimum = min(self.minimum, totalCost)
            return
        
        if totalCost > self.minimum:
            return
        
        if color == 0:
            self.helper(costs, i+1, 1, totalCost + costs[i][color])
            self.helper(costs, i+1, 2, totalCost + costs[i][color])
        elif color == 1:
            self.helper(costs, i+1, 0, totalCost + costs[i][color])
            self.helper(costs, i+1, 2, totalCost + costs[i][color])
        elif color == 2:
            self.helper(costs, i+1, 0, totalCost + costs[i][color])
            self.helper(costs, i+1, 1, totalCost + costs[i][color])
            
if __name__ == "__main__":
    costs = [[17, 2, 17],
              [16, 6, 5], 
              [14, 3, 19],
              [2, 4, 5]]
    
    sol = Solution()
    print(sol.minCost(costs))

# int based recursion

class Solution:
    minimum = float('inf')
    def minCost(self, costs):
        costR = self.helper(costs, 0, 0, 0) #starting from 0th house and choosing red
        costB = self.helper(costs, 0, 1, 0) #starting from 0th house and choosing blue
        costG = self.helper(costs, 0, 2, 0) #starting from 0th house and choosing green
        return min(costR, min(costB, costG))
        
    def helper(self, costs, i, color, totalCost):
        
        if i == len(costs):
            return totalCost
        
        if color == 0:
            return min(self.helper(costs, i+1, 1, totalCost + costs[i][color]),
                self.helper(costs, i+1, 2, totalCost + costs[i][color]))
        elif color == 1:
            return min(self.helper(costs, i+1, 0, totalCost + costs[i][color]),
                self.helper(costs, i+1, 2, totalCost + costs[i][color]))
        elif color == 2:
            return min(self.helper(costs, i+1, 0, totalCost + costs[i][color]),
                self.helper(costs, i+1, 1, totalCost + costs[i][color]))
            
        return 34
            
if __name__ == "__main__":
    costs = [[17, 2, 17],
              [16, 6, 5], 
              [14, 3, 19],
              [2, 4, 5]]
    
    sol = Solution()
    print(sol.minCost(costs))

# If there are multiple colors. Use a for loop
# TC: 3 * 2^n
# SC: O(n)
class Solution:
    minimum = float('inf')
    def minCost(self, costs):
        costR = self.helper(costs, 0, 0, 0) #starting from 0th house and choosing red
        costB = self.helper(costs, 0, 1, 0) #starting from 0th house and choosing blue
        costG = self.helper(costs, 0, 2, 0) #starting from 0th house and choosing green
        return min(costR, min(costB, costG))
        
    def helper(self, costs, i, color, totalCost):
        
        if i == len(costs):
            return totalCost
        
        for j in range(0, 3):
            if j == color: continue
            self.minimum = min(self.minimum, self.helper(costs, i+1, j, totalCost + costs[i][color]))
            
        return self.minimum
            
if __name__ == "__main__":
    costs = [[17, 2, 17],
              [16, 6, 5], 
              [14, 3, 19],
              [2, 4, 5]]
    
    sol = Solution()
    print(sol.minCost(costs))

# DP with tabulation. Bottom-up approach
class Solution:
    
    def minCost(self, costs):
        m = len(costs)
        dp = [[0] * 3 for _ in range(m)]
        
        dp[m-1][0] = costs[m-1][0]
        dp[m-1][1] = costs[m-1][1]
        dp[m-1][2] = costs[m-1][2]
        
        for i in range(m-2, -1, -1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1], dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0], dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0], dp[i+1][1])
                    
        return min(dp[0][0], min(dp[0][1], dp[0][2]))
        
            
if __name__ == "__main__":
    costs = [[17, 2, 17],
              [16, 6, 5], 
              [14, 3, 19],
              [2, 4, 5]]
    
    sol = Solution()
    print(sol.minCost(costs))

# DP with 1D array

class Solution:
    
    def minCost(self, costs):
        m = len(costs)
        dp = [0] * 3
        
        dp[0] = costs[m-1][0]
        dp[1] = costs[m-1][1]
        dp[2] = costs[m-1][2]
        
        for i in range(m-2, -1, -1):
            tempR = dp[0]
            tempB = dp[1]
            dp[0] = costs[i][0] + min(dp[1], dp[2])
            dp[1] = costs[i][1] + min(tempR, dp[2])
            dp[2] = costs[i][2] + min(tempR, tempB)
                    
        return min(dp[0], min(dp[1], dp[2]))
        
            
if __name__ == "__main__":
    costs = [[17, 2, 17],
              [16, 6, 5], 
              [14, 3, 19],
              [2, 4, 5]]
    
    sol = Solution()
    print(sol.minCost(costs))

# Without any extra space. Instead of using a DP array, assigning to variables
class Solution:
    
    def minCost(self, costs):
        m = len(costs)
        dp = [0] * 3
        
        costR = costs[m-1][0]
        costB = costs[m-1][1]
        costG = costs[m-1][2]
        
        for i in range(m-2, -1, -1):
            tempR = costR
            tempB = costB
            costR = costs[i][0] + min(costB, costG)
            costB = costs[i][1] + min(tempR, costG)
            costG = costs[i][2] + min(tempR, tempB)
                    
        return min(costR, min(costB, costG))
        
            
if __name__ == "__main__":
    costs = [[17, 2, 17],
              [16, 6, 5], 
              [14, 3, 19],
              [2, 4, 5]]
    
    sol = Solution()
    print(sol.minCost(costs))