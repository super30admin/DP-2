'''
Time Complexity: O(N*3)
Space Complexity: O(N*3)
'''
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        la = {
            0:[1,2],
            1: [0,2],
            2: [0,1]
        }
        minval = float("inf")
        matrix = costs.copy()
        for i in range(len(matrix)-1, -1, -1):
            for j in range(0,3):
                if(i < len(matrix)-1):
                    matrix[i][j] += min(matrix[i+1][la[j][0]], matrix[i+1][la[j][1]])
                if(i==0):
                    if(matrix[i][j]<minval):
                        minval = matrix[i][j]
        print(matrix)
        return minval