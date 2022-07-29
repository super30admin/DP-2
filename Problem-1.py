#  Paint House
'''
Leetcode all test cases passed: Yes
Solution:
    def choice(self,matrix,i,j):
        Space Complexity: O(1)
        Time Complexity: O(1)
    def minCost(self, costs: List[List[int]]) -> int:
        n is the number of columns
        m is the number of rows
        Space Complexity: O(1)
        Time Complexity: O(n * m)
'''
class Solution:
    def choice(self,matrix,i,j):
        if j == 0:
            return min(matrix[i+1][j+1],matrix[i+1][j+2]) + matrix[i][j]
        if j == 1:
            return min(matrix[i+1][j-1],matrix[i+1][j+1]) + matrix[i][j]
        if j == 2:
            return min(matrix[i+1][j-2],matrix[i+1][j-1]) + matrix[i][j]

    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(len(costs) - 2 ,-1, -1):
            for j in range(len(costs[0])):
                costs[i][j] = self.choice(costs,i,j)
        return min(costs[0])
