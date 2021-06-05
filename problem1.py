class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
      matrix = [[0]*len(costs[0]) for _ in range(len(costs))]
      matrix = costs
      for i in range(1,len(costs)):
        matrix[i][0] = matrix[i][0] + min(matrix[i-1][1], matrix[i-1][2])
        matrix[i][1] = matrix[i][1] + min(matrix[i-1][0], matrix[i-1][2])
        matrix[i][2] = matrix[i][2] + min(matrix[i-1][0], matrix[i-1][1])
      
      return(min(matrix[len(matrix)-1][0], min(matrix[len(matrix)-1][1],matrix[len(matrix)-1][2])))

#Time complexity and space complexity is O(n) where n is the number of houses
#Top down DP approach is used 
#Space complexity can be improved further to O(1) by not creating matrix array and simply modifying the costs array itself.
#Test case used is [[17,2,11], [16,5,20], [14,13,19]]