class Solution:
    def minCost(self, costs):
        #Time Complexity: O(n) 
        #Space Complexity: O(1) // O(n) with the path matrix
        #where, n is the number of houses
        
        if len(costs) == 0:
            return 0
        
        path_matrix = [[None for col in range(len(costs[0]))] for row in range(len(costs) - 1)]
        
        for row in range(len(costs) - 2, -1, -1):
            costs[row][0] += min(costs[row + 1][1], costs[row + 1][2])
            path_matrix[row][0] = 1 if costs[row + 1][1] <= costs[row + 1][2] else 2
            
            costs[row][1] += min(costs[row + 1][0], costs[row + 1][2])
            path_matrix[row][1] = 0 if costs[row + 1][0] <= costs[row + 1][2] else 2
            
            costs[row][2] += min(costs[row + 1][0], costs[row + 1][1])
            path_matrix[row][2] = 0 if costs[row + 1][0] <= costs[row + 1][1] else 1
            
        min_path = [costs[0].index(min(costs[0]))]
        for row in range(len(path_matrix)):      
            min_path.append(path_matrix[row][min_path[-1]])
        
        return min(costs[0]), min_path

#Driver code
cost_matrix = [[0,8,9],[1,0,11],[11,2,3]]
min_cost, min_path = Solution().minCost(cost_matrix)

print("Min cost:", min_cost)
print("Min path:", min_path)