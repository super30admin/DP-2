class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        # Base condition
        if len(costs) == 0:
            return 0
        
        # If there is only one row then get the minimum of first row
        if len(costs) == 1:
            return min(costs[0])
        
        row = len(costs)
        
        # seeting the dp matrix to the same length as the costs matrix
        dp = [[0 for _ in range(3)] for _ in range(len(costs))]
        
        # Setting the last row of dp marix equivalent to costs matrix
        # for j in range(3):
        #     dp[row - 1][j] = costs[row - 1][j]
            
        # Looping reverse in the mtrix from the last second row so that we can get the minimum at each level    
        for i in range(row - 2, -1, -1):
            for j in range(3):
                
                
                # If the house is red then get the minimum between green and blue of the next house and add it to the current cost of paint
                # Same for the ones below
                if j == 0:
                    costs[i][j] = costs[i][j] + min(costs[i+1][j+1], costs[i+1][j+2])
                    
                if j == 1:
                    costs[i][j] = costs[i][j] + min(costs[i+1][j-1], costs[i+1][j+1])
                
                if j == 2:
                    costs[i][j] = costs[i][j] + min(costs[i+1][j-1], costs[i+1][j-2])
                    
        return min(costs[0]) # Returning the minimum of the first row
    
        # Time Complexity: O(n) It is actually 3*n that will be n where n is the number of houses
        # Space Complexity: O(1) because we didn't use extra matrix. 